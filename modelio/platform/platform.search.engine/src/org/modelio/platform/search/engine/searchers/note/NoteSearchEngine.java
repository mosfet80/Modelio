/*
 * Copyright 2013-2025 Docaposte
 *
 * This file is part of Modelio.
 *
 * Modelio is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Modelio is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Modelio.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package org.modelio.platform.search.engine.searchers.note;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.infrastructure.Element;
import org.modelio.metamodel.uml.infrastructure.Note;
import org.modelio.platform.search.engine.api.ISearchCriteria;
import org.modelio.platform.search.engine.api.ISearchEngine;
import org.modelio.platform.search.engine.api.ModelSearchResult;
import org.modelio.vcore.session.api.ICoreSession;
import org.modelio.vcore.session.api.model.IModel;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * The SearchEngine is able to find all the model elements matching its
 * criteria. The SearchEngine criteria are:
 * <ul>
 * <li>a regular expression used to match the model element name</li>
 * <li>a set of metaclasses defining the nature of the searched elements
 * <li>several boolean flags (eg: include/exclude RAMC)</li>
 * <li>a stereotype</li>
 *
 * @author phv
 */
@objid ("bd9547e8-16cc-4f56-8eec-1be0b278296c")
public class NoteSearchEngine implements ISearchEngine {
    @objid ("ab99cdc6-5d67-4a0b-a74a-9d8582d1dc7d")
    public NoteSearchEngine() {

    }

    @objid ("d6d902b9-55bb-4f40-8569-a01adc99707a")
    @Override
    public ModelSearchResult search(ICoreSession session, ISearchCriteria params) {
        assert (params instanceof NoteSearchCriteria);

        final NoteSearchCriteria criteria = (NoteSearchCriteria) params;

        // Collect raw results
        final Collection<? extends MObject> rawResults = session.getModel().findByClass(session.getMetamodel().getMClass(Note.class), IModel.NODELETED);
        final List<Element> filteredResults = new ArrayList<>();

        try {
            final int flags = (criteria.isCaseSensitive()) ? 0 : Pattern.CASE_INSENSITIVE;
            final String noteType = (criteria.getNoteType().isEmpty() ? ".*" : criteria.getNoteType());
            final Pattern typePattern = Pattern.compile(noteType);
            final Pattern contentsPattern = Pattern.compile(criteria.getExpression(), flags);

            for (final MObject mObject : rawResults) {
                final Note note = (Note) mObject;

                // check note type
                if (!typePattern.matcher(note.getModel().getName()).matches()) {
                    continue;
                }

                // check text condition
                String content = note.getContent();
                if (note.getMimeType().equals("text/html")) {
                    content = decodeContent(content);
                }
                if (!contentsPattern.matcher(content).find()) {
                    continue;
                }

                // if reached, mObject is matching all the criteria, add it to results
                filteredResults.add(note);
            }

        } catch (final PatternSyntaxException e) {
            // do nothing, will simply return an empty list
        }
        return new ModelSearchResult(filteredResults, new ArrayList<>());
    }

    @objid ("90b2b6ea-0f68-41f2-affb-0073f332e8f2")
    private String decodeContent(String content) {
        if (content == null)
            return null;

        // Decode numeric (&#123; &#xAB;) and named (&eacute; &amp; etc.) HTML entities
        Matcher m = Pattern.compile("&(?:#(?:x([0-9a-fA-F]+)|([0-9]+))|([a-zA-Z]+));").matcher(content);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            String replacement;
            if (m.group(1) != null) {
                // Hex numeric entity &#xAB;
                int codePoint = Integer.parseInt(m.group(1), 16);
                replacement = new String(Character.toChars(codePoint));
            } else if (m.group(2) != null) {
                // Decimal numeric entity &#123;
                int codePoint = Integer.parseInt(m.group(2));
                replacement = new String(Character.toChars(codePoint));
            } else {
                // Named entity &eacute;
                String decoded = resolveNamedEntity(m.group(3));
                replacement = decoded != null ? decoded : m.group(0);
            }
            m.appendReplacement(sb, Matcher.quoteReplacement(replacement));
        }
        m.appendTail(sb);
        return sb.toString();
    }

    @objid ("237071e2-7811-4dfe-93b2-9d616197a322")
    @SuppressWarnings("javadoc")
    private static String resolveNamedEntity(String name) {
        // Use a temporary HTML document to let the JDK decode the entity
        try {
            javax.swing.text.html.HTMLEditorKit.ParserCallback callback = new javax.swing.text.html.HTMLEditorKit.ParserCallback() {
                String result = null;

                @Override
                public void handleText(char[] data, int pos) {
                    this.result = new String(data);
                }
            };
            String html = "<html><body>&" + name + ";</body></html>";
            new javax.swing.text.html.parser.ParserDelegator().parse(
                    new java.io.StringReader(html), callback, true);

            java.lang.reflect.Field f = callback.getClass().getDeclaredField("result");
            f.setAccessible(true);
            return (String) f.get(callback);
        } catch (@SuppressWarnings("unused") Exception e) {
            return null;
        }
    }

}
