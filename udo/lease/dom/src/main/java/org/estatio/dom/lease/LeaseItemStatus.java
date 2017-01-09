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
package org.estatio.dom.lease;

import org.incode.module.base.dom.utils.StringUtils;

public enum LeaseItemStatus {

    SUSPENDED,
    ACTIVE,
    TERMINATED,
    UNKOWN;

    /*
     * The order is used in Lease#getItemStatus. Since 'SUSPENDED' is the only
     * status that affects the calculation we want to show that there is a
     * suspension.
     */

    public String title() {
        return StringUtils.enumTitle(this.name());
    }

    public static LeaseItemStatus valueOfElse(final String status, final LeaseItemStatus statusElse) {
        return status != null ? valueOf(status) : statusElse;
    }

    public static class Meta {

        public final static int MAX_LEN = 20;

        private Meta() {}

    }

}