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
/*
 * Copyright 2013-2024 Docaposte
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
package org.modelio.vstore.exml.resource.migration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import javax.xml.stream.Location;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import org.modelio.vbasic.log.Log;
import org.modelio.vbasic.progress.IModelioProgress;
import org.modelio.vbasic.progress.SubProgress;
import org.modelio.vcore.model.spi.mm.IMigrationReporter;
import org.modelio.vcore.model.spi.mm.IMigrationReporter.IMigrationLogger;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.mapi.MMetamodel;
import org.modelio.vcore.smkernel.mapi.MRef;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.descriptor.MetamodelDescriptor;
import org.modelio.vcore.smkernel.meta.descriptor.MetamodelDescriptorReader;
import org.modelio.vcore.smkernel.meta.descriptor.MetamodelDescriptorWriter;
import org.modelio.vcore.smkernel.meta.mof.MofMetamodel;
import org.modelio.vstore.exml.common.RepositoryVersions;
import org.modelio.vstore.exml.common.model.ExmlTags;
import org.modelio.vstore.exml.plugin.VStoreExml;
import org.modelio.vstore.exml.resource.ExmlFileAccess;
import org.modelio.vstore.exml.resource.ExmlRepositoryGeometries;
import org.modelio.vstore.exml.resource.IExmlRepositoryGeometry;

/**
 * EXML repository format migrator from version 1 to 2.
 *
 * @author cma
 * @since 3.6
 */
@objid ("819f7c20-f311-4694-8ec9-44acae9e2aa9")
public class RepositoryFormatMigrator {
    @objid ("e2401fdb-1df4-443a-9d6b-0ebacaa94c04")
    private final int targetFormat;

    @objid ("b4db4d16-090c-4777-a96b-835639233458")
    private ExmlFileAccess from;

    @objid ("7915f118-0630-459a-b564-d170e8a11c7a")
    private ExmlFileAccess to;

    @objid ("9b596511-5520-49df-9dde-97b8aaf253b6")
    private final Path repositoryPath;

    @objid ("79988858-f798-467f-8380-6df73810f23f")
    private final MofMetamodel metamodel;

    @objid ("1b2d32e0-fc87-4a4d-939c-ae26462cfe96")
    private final IMigrationReporter reporter;

    @objid ("71caa347-3b5e-4ad7-b011-80ef3e16ac0e")
    private Collection<Path> createdDirectories = new HashSet<>();

    /**
     *
     * @param repositoryPath the repository path
     * @param metamodel the metamodel
     */
    @objid ("60554b1c-46d0-4e5a-8150-f71146682cf3")
    public RepositoryFormatMigrator(Path repositoryPath, MMetamodel metamodel, IMigrationReporter reporter, int sourceFormat, int targetFormat) throws IOException {
        this.repositoryPath = repositoryPath;
        this.metamodel = new MofMetamodel();
        this.reporter = reporter;
        this.targetFormat = targetFormat;
        this.from = new ExmlFileAccess(repositoryPath.toFile(), getGeometry(sourceFormat));
        this.to = new ExmlFileAccess(repositoryPath.toFile(), getGeometry(targetFormat));

        this.metamodel.copy(metamodel);
    }

    @objid ("7db49250-2463-4720-a39d-6aedaa74c252")
    private static IExmlRepositoryGeometry getGeometry(int format) throws IOException {
        return ExmlRepositoryGeometries.ofFormat(format);
    }

    /**
     * Run the migration.
     *
     * @param monitor a progress monitor
     * @throws IOException on failure.
     */
    @objid ("9bc676af-f815-411e-9d7b-534996118917")
    public void execute(IModelioProgress monitor) throws IOException {
        SubProgress mon = SubProgress.convert(monitor, 6);
        begin(mon.newChild(1));

        File metamodelDescriptorFile = this.from.getMetamodelDescriptorFile();
        if (metamodelDescriptorFile.isFile()) {
            try (InputStream newInputStream = Files.newInputStream(metamodelDescriptorFile.toPath())) {
                MetamodelDescriptor mmDesc = MetamodelDescriptorReader.readFrom(newInputStream, metamodelDescriptorFile.toString());
                this.metamodel.merge(mmDesc);
            }
        }

        createMissingDirectories(mon.newChild(1));
        moveAllResources(mon.newChild(1));
        deleteObsoleteDirectories(mon.newChild(1));

        new FilesRegenerator(this.to, this.metamodel, f -> fileModified(f)).run(mon.newChild(1));

        saveFormatVersion(mon.newChild(1));

        commit(mon.newChild(1));
    }

    /**
     * Called at the end.
     * <p>
     * Does nothing by default.
     *
     * @param monitor a progress monitor.
     * @throws IOException on failure.
     */
    @objid ("7c6fd12c-2086-45eb-abbd-ba29e38822e6")
    protected void commit(IModelioProgress monitor) throws IOException {
        // nothing by default
    }

    @objid ("7b835a3b-8c10-4368-af2b-658dd252fe43")
    public IMigrationReporter getReporter() {
        return this.reporter;
    }

    /**
     * Called at the beginning.
     * <p>
     * Does nothing by default.
     *
     * @param monitor a progress monitor.
     * @throws IOException on failure.
     */
    @objid ("a9cd2fd4-88fa-4cc0-9faf-6a3e4c940c96")
    protected void begin(IModelioProgress monitor) throws IOException {
        // nothing by default
    }

    @objid ("13f3be64-894b-4360-abc3-2a049d37ea14")
    private void saveFormatVersion(IModelioProgress monitor) throws IOException {
        Path filePath = getFormatVersionFilePath();
        try (OutputStream out = Files.newOutputStream(filePath)) {
            RepositoryVersions format = new RepositoryVersions(this.targetFormat, this.metamodel);
            format.write(out);
        }

        filePath = getMetamodelDescriptorFilePath();
        try (OutputStream out = Files.newOutputStream(filePath)) {
            MetamodelDescriptor desc = this.metamodel.serialize();
            new MetamodelDescriptorWriter().write(desc, out);
        }
    }

    @objid ("bec52050-0b6b-409f-9663-9f138c4ad408")
    private void createMissingDirectories(IModelioProgress monitor) throws IOException {
        Collection<String> newDirs = this.to.getGeometry().getInitialDirectories(this.metamodel);

        SubProgress mon = SubProgress.convert(monitor, newDirs.size());

        for (String newDir : newDirs) {
            Path resolvedNewDir = this.repositoryPath.resolve(newDir);
            if (!Files.isDirectory(resolvedNewDir)) {
                createNewDirectory(resolvedNewDir);
            }
            mon.worked(1);
        }
    }

    @objid ("f541a21f-b319-49d4-a6ab-41f4192b9160")
    private void deleteObsoleteDirectories(IModelioProgress monitor) throws IOException {
        Collection<File> newDirs = this.to.getInitialDirectories(this.metamodel);

        Path modelDir = this.repositoryPath.resolve(this.from.getGeometry().getModelPath());
        try (Stream<Path> entries = Files.list(modelDir)) {
            Collection<Path> oldDirs = entries.collect(Collectors.toList());

            SubProgress mon = SubProgress.convert(monitor, oldDirs.size());

            int i = 0;
            int count = oldDirs.size();
            for (Path oldDir : oldDirs) {
                monitor.subTask(VStoreExml.I18N.getMessage("MigratorFrom1To2.deletingDirectories.progress", i, count));

                if (!newDirs.contains(oldDir.toFile()) && !this.createdDirectories.contains(oldDir)) {
                    deleteDirectory(oldDir);
                }
                mon.worked(1);
            }
        }
    }

    /**
     *
     * @param oldDir the directory path relative to the repository root.
     * @return true if a directory was deleted, false if it didn't exist.
     * @throws IOException on failure
     */
    @objid ("ce724d70-636d-4880-a3fe-61a1739f232f")
    protected boolean deleteDirectory(Path oldDir) throws IOException {
        // The directory should be empty
        try {
            return Files.deleteIfExists(oldDir);
        } catch (DirectoryNotEmptyException e) {
            // Add debugging infos
            try (Stream<Path> entries = Files.list(oldDir)) {
                String content = entries.map(d -> "   - " + d.toString()).collect(Collectors.joining("\n", "Directory content:\n", ""));
                e.addSuppressed(new Throwable(content));
            } catch (IOException e2) {
                e.addSuppressed(e2);
            }
            throw e;
        }
    }

    /**
     * Create a new directory
     *
     * @param newDir the directory path relative to the repository root.
     * @throws IOException on failure
     */
    @objid ("e13a040f-7951-40ab-8004-50a6e77a4be8")
    protected void createNewDirectory(Path newDir) throws IOException {
        Files.createDirectories(newDir);
        this.createdDirectories.add(newDir);
    }

    @objid ("1d047b06-edbc-4b51-bb9f-715fceb88d8c")
    private void moveAllResources(IModelioProgress aMonitor) throws IOException {
        SubProgress monitor = SubProgress.convert(aMonitor, VStoreExml.I18N.getMessage("MigratorFrom1To2.moveAllResources.task"), 10);

        forEachExmlFile(this.from, new IFileOp() {
            private int count = 0;
            private int movedCount = 0;
            private final ExmlFileAccess fromAccess = RepositoryFormatMigrator.this.from;
            private final ExmlFileAccess toAccess = RepositoryFormatMigrator.this.to;

            @Override
            public void run(Path fromPath) throws IOException {
                File fromFile = fromPath.toFile();

                MRef ref = readFixedRef(this.fromAccess, fromFile);
                if (ref != null) {
                    boolean isLocal = fromFile.getPath().endsWith(IExmlRepositoryGeometry.EXT_LOCAL_EXML);
                    Path targetFile = isLocal ? this.toAccess.getLocalExmlFile(ref).toPath() : this.toAccess.getExmlFile(ref).toPath();

                    if (!fromPath.equals(targetFile)) {
                        ensureDirectoryExist(targetFile.getParent());
                        moveFile(fromPath, targetFile);
                        this.movedCount++;
                    }
                }
                this.count++;

                monitor.worked(1);
                monitor.setWorkRemaining(10);
                monitor.subTask(VStoreExml.I18N.getMessage("MigratorFrom1To2.moveAllResources.progress", this.count, this.movedCount));

            }
        });
    }

    @objid ("dd969ec2-4d0b-4fed-87bf-cdccf3592b70")
    protected void moveFile(Path fromPath, Path targetPath) throws IOException {
        Files.move(fromPath, targetPath);
    }

    @objid ("ef135ef0-9879-47a7-ba0a-03a6899192cd")
    protected Path getFormatVersionFilePath() {
        return this.repositoryPath.resolve(IExmlRepositoryGeometry.FORMAT_VERSION_PATH);
    }

    @objid ("988d58d1-65d8-4f67-affa-178d3840fa93")
    protected Path getRepositoryPath() {
        return this.repositoryPath;
    }

    @objid ("7361f474-2951-47a4-9867-7cceca3e5d61")
    protected final IMigrationLogger getLogger() {
        return this.reporter.getLogger();
    }

    @objid ("afb64154-cff3-4bf4-bcdc-72f4e40ee059")
    protected final MMetamodel getMetamodel() {
        return this.metamodel;
    }

    @objid ("ab18c622-acdc-40e5-b049-58df7c243053")
    private MRef readFixedRef(ExmlFileAccess reader, File fromFile) throws IOException {
        MRef ret = reader.readRefFromFile(fromFile);
        if (ret != null) {
            MClass mc = this.metamodel.getMClass(ret.mc);
            if (mc == null) {
                getLogger().printf("  warn: %s: Unknown metaclass for '%s'.\n", fromFile, ret);
            } else if (!mc.getQualifiedName().equals(ret.mc)) {
                getLogger().printf("  warn: %s: metaclass fixed to '%s' for '%s'.\n", fromFile, mc.getQualifiedName(), ret);
                ret = new MRef(mc.getQualifiedName(), ret.uuid, ret.name);
            }
        }
        return ret;
    }

    @objid ("6dbea803-e3ef-4741-ab8e-2f2d766e81cd")
    private void ensureDirectoryExist(Path dirPath) throws IOException {
        if (!Files.isDirectory(dirPath)) {
            createNewDirectory(dirPath);
        }
    }

    @objid ("372ca93b-20cd-497a-a356-12de30000f99")
    protected final Path getMetamodelDescriptorFilePath() {
        return this.repositoryPath.resolve(this.to.getGeometry().getMetamodelDescriptorPath());
    }

    @objid ("7ee549df-0ffc-4b5d-ab4e-a31e1b18fce0")
    protected static final void forEachExmlFile(ExmlFileAccess access, IFileOp op) throws IOException {
        try (Stream<Path> fileStream = Files.find(
                access.getModelDirectory().toPath(),
                10,
                (Path p,BasicFileAttributes atts) ->  p.toString().endsWith(IExmlRepositoryGeometry.EXT_EXML));) {
            for (Iterator<Path> it = fileStream.iterator(); it.hasNext(); ) {
                Path fromPath = it.next();
                op.run(fromPath);
            }
        }
    }

    /**
     * Report a file as modified.
     *
     * @param modifiedFile the modified file
     * @throws IOException on hook failure.
     */
    @objid ("700c3c71-a079-4ee1-897e-45ec792e36cc")
    protected void fileModified(Path modifiedFile) throws IOException {
        // nothing by default
    }

    /**
     * EXML file regenerator that converts short metaclass names to qualified metaclass names.
     *
     * @author cma
     * @since 3.7
     */
    @objid ("2d4a21cf-b0c6-4bf3-ab03-f0162ad9cd48")
    protected static class FilesRegenerator {
        @objid ("10334f59-f0f5-4b06-a7ff-8cfeb88e37b3")
        private long count;

        @objid ("a85893bb-3127-4651-ae1c-de9e197f52b1")
        private static final Collection<String> tagsToConvert = new HashSet<>(Arrays.asList(
                                                                        ExmlTags.TAG_COMPID,
                                                                        ExmlTags.TAG_CMSNODE_PID,
                                                                        ExmlTags.TAG_DEPS_EXTID,
                                                                        ExmlTags.TAG_FOREIGNID,
                                                                        ExmlTags.TAG_ID,
                                                                        ExmlTags.TAG_PID));

        @objid ("65044be9-81be-4de7-9c8b-b68ff7554fe2")
        private final ExmlFileAccess exmlAccess;

        @objid ("045f0239-aafe-4fda-bc6c-e0691a885501")
        private final MofMetamodel metamodel;

        @objid ("eb9daa9e-d3aa-4c69-8974-ab512f02d6f6")
        private final IFileOp fileModifiedHook;

        @objid ("fd80f4eb-9714-4e58-9694-43740e2e5185")
        private final XMLEventFactory eventFactory;

        @objid ("e6a5a7b6-700c-4423-b5ee-7f06c15a55cb")
        public FilesRegenerator(ExmlFileAccess exmlAccess, MofMetamodel metamodel, IFileOp fileModifiedHook) {
            super();
            this.exmlAccess = exmlAccess;
            this.metamodel = metamodel;
            this.fileModifiedHook = fileModifiedHook;
            this.eventFactory = XMLEventFactory.newInstance();
        }

        @objid ("c80356a6-f794-4455-b99f-44b72c268274")
        public void run(IModelioProgress amonitor) throws IOException {
            SubProgress monitor = SubProgress.convert(amonitor, 5);

            XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();

            forEachExmlFile(this.exmlAccess, exmlFile -> {
                Path tmpFile = Files.createTempFile("", ".exml");

                try(InputStream is = Files.newInputStream(exmlFile);
                        OutputStream os = Files.newOutputStream(tmpFile);)
                {
                    XMLEventReader evReader = inputFactory.createXMLEventReader(exmlFile.toString(), is);
                    XMLEventWriter evWriter = outputFactory.createXMLEventWriter(os, StandardCharsets.UTF_8.name());

                    try (XmlCloser c1 = evReader::close; XmlCloser c2 = evWriter::close;)
                    {
                        rewriteResourceContent(evReader, evWriter);
                    }
                } catch (XMLStreamException e) {
                    throw new IOException(e.getLocalizedMessage(), e);
                }

                // replace original by rewritten content
                Files.copy(tmpFile, exmlFile, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
                this.fileModifiedHook.run(exmlFile);

                Files.delete(tmpFile);
                monitor.worked(1);
                monitor.setWorkRemaining(5);

                monitor.subTask(VStoreExml.I18N.getMessage("FilesRegenerator.progress", ++this.count));
            });
        }

        @objid ("d19f9b49-bf51-48e2-8333-0500c406861e")
        private void rewriteResourceContent(XMLEventReader reader, XMLEventWriter writer) throws XMLStreamException {
            while(reader.hasNext()) {
                XMLEvent event = (XMLEvent) reader.next();
                if (event.getEventType() == XMLStreamConstants.START_ELEMENT
                        && tagsToConvert.contains(event.asStartElement().getName().getLocalPart())) {
                    event = convertIdTag(event.asStartElement());
                }
                writer.add(event);
            }
        }

        @objid ("dec6d947-9c18-4b90-bc11-d621949bb39a")
        private XMLEvent convertIdTag(StartElement event) {
            List<Attribute> atts = new ArrayList<>(5);

            for (Iterator<Attribute> it = event.getAttributes(); it.hasNext();) {
                Attribute att = it.next();
                if (att.getName().getLocalPart().equals(ExmlTags.ATT_ID_MC)) {
                    String oldMc = att.getValue();
                    SmClass mc = this.metamodel.getMClass(oldMc);
                    if (mc == null) {
                        final Location loc = event.getLocation();
                        Log.warning("%s: Unknow '%s' metaclass found at %s:%d:%d", getClass().getSimpleName(), oldMc, loc.getSystemId(), loc.getLineNumber(), loc.getColumnNumber());
                        atts.add(att);
                    } else if (mc.getQualifiedName().equals(oldMc)) {
                        atts.add(att);
                    } else {
                        // replace by qualified metaclass name
                        atts.add(this.eventFactory.createAttribute(att.getName(), mc.getQualifiedName()));
                    }
                } else {
                    atts.add(att);
                }
            }
            return this.eventFactory.createStartElement(event.getName(), atts.iterator(), event.getNamespaces());
        }

    }

    @objid ("e03bc8dc-45c4-4ed8-8179-35ef261887f4")
    @FunctionalInterface
    private interface IFileOp {
        @objid ("d3f47a3a-6f57-420e-96c1-d2657076f0fb")
        void run(Path p) throws IOException;

    }

    /**
     * {@link AutoCloseable} function to close an {@link XMLEventReader} or {@link XMLEventWriter}.
     *
     * @author cma
     * @since 3.7
     */
    @objid ("8ae7bd24-3659-4cbf-b317-0f4327210e26")
    @FunctionalInterface
    private interface XmlCloser extends AutoCloseable {
        @objid ("66fd61a0-d990-4870-ba37-2e76b3607719")
        @Override
        void close() throws XMLStreamException;

    }

}
