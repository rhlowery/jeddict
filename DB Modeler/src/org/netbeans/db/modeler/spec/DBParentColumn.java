/**
 * Copyright [2016] Gaurav Gupta
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.netbeans.db.modeler.spec;

import org.netbeans.jpa.modeler.spec.Entity;
import org.netbeans.jpa.modeler.spec.extend.Attribute;

public abstract class DBParentColumn<E extends Attribute> extends DBColumn<E> {

    private final Entity intrinsicClass;//parent class
    private String keyName;


    public DBParentColumn(String name, Entity intrinsicClass, E managedAttribute) {
        super(name, managedAttribute);
        this.intrinsicClass = intrinsicClass;
    }


    protected String getKeyName() {
        if (keyName != null) {
            return keyName;
        }
        keyName = getAttribute().getName();
        return keyName;
    }
}
