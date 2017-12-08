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
package org.estatio.module.lease.fixtures.leaseitems.percentage.personas;

import org.estatio.module.lease.fixtures.LeaseItemAndTermsAbstract;
import org.estatio.module.lease.fixtures.lease.enums.Lease_enum;
import org.estatio.module.lease.fixtures.leaseitems.percentage.enums.LeaseItemForPercentage_enum;

public class LeaseItemAndLeaseTermForPercentageForOxfTopModel001Gb extends LeaseItemAndTermsAbstract {


    @Override
    protected void execute(final ExecutionContext fixtureResults) {

        // prereqs
        fixtureResults.executeChild(this, Lease_enum.OxfTopModel001Gb.builder());

        // exec
        fixtureResults.executeChild(this, LeaseItemForPercentage_enum.OxfTopModel001Gb.builder());

    }

}
