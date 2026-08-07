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
package org.modelio.archimate.metamodel.relationships.dependency;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * InfluenceStrength vnull
 *
 *
 * <p>Defines the&nbsp;possible values of <em>Influence</em> relationships. By default, the influence relationship models a contribution with unspecified sign and strength.</p><p>Values are sorted from the most negative to the most positive one.</p>
 *
 *
 */
@objid ("0fb6d564-a07e-4215-9247-00f34e118f38")
public enum InfluenceStrength {
    @objid ("d4dab9c7-f59c-44a4-b0fd-3070be63577d")
    STRONGLYNEGATIVE(0, "STRONGLYNEGATIVE", "STRONGLYNEGATIVE"),
    @objid ("a702e98d-8d6b-4260-a5aa-30758c97a6fb")
    SLIGHTLYNEGATIVE(1, "SLIGHTLYNEGATIVE", "SLIGHTLYNEGATIVE"),
    @objid ("d7890664-d46c-453f-8aae-9ed5cdb34bff")
    UNDEFINED(2, "UNDEFINED", "UNDEFINED"),
    @objid ("ed953325-132e-43c3-9d43-be192d7308ce")
    SLIGHTLYPOSITIVE(3, "SLIGHTLYPOSITIVE", "SLIGHTLYPOSITIVE"),
    @objid ("fb2b5f9f-e235-42b9-b13a-cfdb93c23420")
    STRONGLYPOSITIVE(4, "STRONGLYPOSITIVE", "STRONGLYPOSITIVE"),
    @objid ("a81655bc-5b19-462c-9771-716ef023acb9")
    ZERO(5, "ZERO", "ZERO"),
    @objid ("58b920e9-f2d3-4776-bd65-ff06fcfe23e6")
    ONE(6, "ONE", "ONE"),
    @objid ("9ddf9ad7-5603-4751-93b5-a3f5ff749707")
    TWO(7, "TWO", "TWO"),
    @objid ("6dff1565-76ff-425c-aa8b-290cf448d3e4")
    THREE(8, "THREE", "THREE"),
    @objid ("232d772a-d068-4901-8979-69adbcd8ea7b")
    FOUR(9, "FOUR", "FOUR"),
    @objid ("668e4c86-2e7b-45c9-86c7-439f45bb5385")
    FIVE(10, "FIVE", "FIVE"),
    @objid ("40f482d4-9dee-411d-aa43-baf95873e80d")
    SIX(11, "SIX", "SIX"),
    @objid ("4e9fed23-0bcc-4775-98bb-a174e44ce048")
    SEVEN(12, "SEVEN", "SEVEN"),
    @objid ("72081790-ac0b-4f10-ae05-d78bc0d3eb64")
    EIGHT(13, "EIGHT", "EIGHT"),
    @objid ("f62d7f28-13a4-4352-921f-f3d0923c37e4")
    NINE(14, "NINE", "NINE"),
    @objid ("7a2490a0-fd4f-4da7-9903-295c63c2adf4")
    TEN(15, "TEN", "TEN");

    @objid ("a88a416a-b1dc-438e-a271-eb3712cf9b67")
    public static final String STRONGLYNEGATIVE_NAME = "STRONGLYNEGATIVE";

    @objid ("3db39886-8be2-4a73-8416-b13670192595")
    public static final String SLIGHTLYNEGATIVE_NAME = "SLIGHTLYNEGATIVE";

    @objid ("64bf9e98-ec91-4fc6-89c4-8ce071980822")
    public static final String UNDEFINED_NAME = "UNDEFINED";

    @objid ("b2eb9cd1-f020-4cf9-91e8-7614ccf3129f")
    public static final String SLIGHTLYPOSITIVE_NAME = "SLIGHTLYPOSITIVE";

    @objid ("e7b14537-2570-4d4e-a4c3-0fd549c98fec")
    public static final String STRONGLYPOSITIVE_NAME = "STRONGLYPOSITIVE";

    @objid ("91501b18-4b85-46e3-957b-760a8cd3322b")
    public static final String ZERO_NAME = "ZERO";

    @objid ("2ce946b3-c2b5-4aca-90de-6db16123918e")
    public static final String ONE_NAME = "ONE";

    @objid ("ed580bc4-5e76-42a9-9db8-467e1ada2af9")
    public static final String TWO_NAME = "TWO";

    @objid ("cbff05bd-476c-4d3d-9fc3-051c29bf4f63")
    public static final String THREE_NAME = "THREE";

    @objid ("ae72cb56-3e43-40b8-836c-5a089aa9919d")
    public static final String FOUR_NAME = "FOUR";

    @objid ("3b9f474c-1878-4843-b675-5fa2e50364fa")
    public static final String FIVE_NAME = "FIVE";

    @objid ("3089f32e-940f-4efc-9df6-ef1ac1aa1664")
    public static final String SIX_NAME = "SIX";

    @objid ("d67de221-362c-4535-9290-60056b97a147")
    public static final String SEVEN_NAME = "SEVEN";

    @objid ("dac93d0f-5492-4a93-9b50-f8932bb446c8")
    public static final String EIGHT_NAME = "EIGHT";

    @objid ("46ee60e4-3648-4f50-a15a-a271bc10dfb5")
    public static final String NINE_NAME = "NINE";

    @objid ("4a1b8cb3-78bf-479c-9845-75a690339079")
    public static final String TEN_NAME = "TEN";

public static final int STRONGLYNEGATIVE_VALUE = 0;
    public static final int SLIGHTLYNEGATIVE_VALUE = 1;
    public static final int UNDEFINED_VALUE = 2;
    public static final int SLIGHTLYPOSITIVE_VALUE = 3;
    public static final int STRONGLYPOSITIVE_VALUE = 4;
    public static final int ZERO_VALUE = 5;
    public static final int ONE_VALUE = 6;
    public static final int TWO_VALUE = 7;
    public static final int THREE_VALUE = 8;
    public static final int FOUR_VALUE = 9;
    public static final int FIVE_VALUE = 10;
    public static final int SIX_VALUE = 11;
    public static final int SEVEN_VALUE = 12;
    public static final int EIGHT_VALUE = 13;
    public static final int NINE_VALUE = 14;
    public static final int TEN_VALUE = 15;
    private static final InfluenceStrength[] VALUES_ARRAY =
    new InfluenceStrength[] {
    STRONGLYNEGATIVE,
    SLIGHTLYNEGATIVE,
    UNDEFINED,
    SLIGHTLYPOSITIVE,
    STRONGLYPOSITIVE,
    ZERO,
    ONE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    };
    public static final List<InfluenceStrength> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));
    public static InfluenceStrength get(String literal) {
      for (int i = 0; i < VALUES_ARRAY.length; ++i) {
        InfluenceStrength result = VALUES_ARRAY[i];
        if (result.toString().equals(literal)) {
           return result;
        }
      }
      return null;
    }
    public static InfluenceStrength getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
    InfluenceStrength result = VALUES_ARRAY[i];
    if (result.getName().equals(name)) {
    return result;
    }
    }
    return null;
    }
    public static InfluenceStrength get(int value) {
        switch (value) {
            case STRONGLYNEGATIVE_VALUE: return STRONGLYNEGATIVE;
            case SLIGHTLYNEGATIVE_VALUE: return SLIGHTLYNEGATIVE;
            case UNDEFINED_VALUE: return UNDEFINED;
            case SLIGHTLYPOSITIVE_VALUE: return SLIGHTLYPOSITIVE;
            case STRONGLYPOSITIVE_VALUE: return STRONGLYPOSITIVE;
            case ZERO_VALUE: return ZERO;
            case ONE_VALUE: return ONE;
            case TWO_VALUE: return TWO;
            case THREE_VALUE: return THREE;
            case FOUR_VALUE: return FOUR;
            case FIVE_VALUE: return FIVE;
            case SIX_VALUE: return SIX;
            case SEVEN_VALUE: return SEVEN;
            case EIGHT_VALUE: return EIGHT;
            case NINE_VALUE: return NINE;
            case TEN_VALUE: return TEN;
        }
        return null;
    }
    private final int value;
    private final String name;
    private final String literal;
    private InfluenceStrength(int value, String name, String literal) {
      this.value = value;
      this.name = name;
      this.literal = literal;
    }
    public int getValue() {
       return value;
    }
     public String getName() {
        return name;
    }
    public String getLiteral() {
      return literal;
    }
     @Override
    public String toString() {
       return literal;
    }

}
