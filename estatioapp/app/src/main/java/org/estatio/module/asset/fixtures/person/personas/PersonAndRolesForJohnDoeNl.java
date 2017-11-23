/*
 *
 *  Copyright 2012-2014 Eurocommercial Properties NV
 *
 *
 *  Licensed under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.estatio.module.asset.fixtures.person.personas;

import org.apache.isis.applib.fixturescripts.FixtureScript;

import org.estatio.module.party.dom.PersonGenderType;
import org.estatio.module.base.fixtures.security.apptenancy.personas.ApplicationTenancyForNl;
import org.estatio.module.asset.fixtures.person.builders.PersonAndCommsAndRelationshipAndFixedAssetRolesBuilder;

public class PersonAndRolesForJohnDoeNl extends FixtureScript {

    public static final String REF = "JDOE";
    public static final String AT_PATH = ApplicationTenancyForNl.PATH;

    @Override
    protected void execute(FixtureScript.ExecutionContext executionContext) {

        getContainer().injectServicesInto(new PersonAndCommsAndRelationshipAndFixedAssetRolesBuilder())
                    .setAtPath(AT_PATH)
                    .setReference(REF)
                    .setInitials("J")
                    .setFirstName("John")
                    .setLastName("Doe")
                    .setPersonGenderType(PersonGenderType.MALE)
                .execute(executionContext);

    }
}