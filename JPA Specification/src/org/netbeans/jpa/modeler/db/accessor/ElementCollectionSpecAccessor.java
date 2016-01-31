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
package org.netbeans.jpa.modeler.db.accessor;

import org.eclipse.persistence.internal.jpa.metadata.accessors.mappings.ElementCollectionAccessor;
import org.netbeans.jpa.modeler.spec.ElementCollection;
import org.netbeans.jpa.modeler.spec.extend.Attribute;

/**
 *
 * @author Gaurav Gupta
 */
public class ElementCollectionSpecAccessor extends ElementCollectionAccessor {

    private ElementCollection elementCollection;

    private ElementCollectionSpecAccessor(ElementCollection elementCollection) {
        this.elementCollection = elementCollection;
    }

    public static ElementCollectionSpecAccessor getInstance(ElementCollection elementCollection) {
        ElementCollectionSpecAccessor accessor = new ElementCollectionSpecAccessor(elementCollection);
        accessor.setName(elementCollection.getName());
        
            accessor.setAttributeType(elementCollection.getCollectionType());
            accessor.setTargetClassName(elementCollection.getTargetClass());
        
        if (elementCollection.getColumn() != null) {
            accessor.setColumn(elementCollection.getColumn().getAccessor());
        }
        if (elementCollection.getCollectionTable() != null) {
            accessor.setCollectionTable(elementCollection.getCollectionTable().getAccessor());
        }
        return accessor;

    }

    @Override
    public void process() {
        super.process();
        getMapping().setProperty(Attribute.class, elementCollection);
    }

}