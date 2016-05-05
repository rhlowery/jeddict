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
package org.netbeans.jpa.modeler.spec.validator;

import org.apache.commons.lang.StringUtils;
import org.netbeans.jpa.modeler.spec.TableGenerator;

/**
 *
 * @author Gaurav Gupta
 */
public class TableGeneratorValidator  extends MarshalValidator<TableGenerator> {

    @Override
    public TableGenerator marshal(TableGenerator tableGenerator) throws Exception {
        if (tableGenerator != null && isEmpty(tableGenerator)) {
            return null;
        }
        return tableGenerator;
    }
    
    public static boolean isEmpty(TableGenerator tableGenerator) { //TODO Index & UniqueConstraints
        return StringUtils.isBlank(tableGenerator.getName()) && StringUtils.isBlank(tableGenerator.getCatalog()) && StringUtils.isBlank(tableGenerator.getSchema())
                && StringUtils.isBlank(tableGenerator.getPkColumnName()) && StringUtils.isBlank(tableGenerator.getPkColumnValue()) 
                && StringUtils.isBlank(tableGenerator.getTable()) 
                && tableGenerator.getAllocationSize()== 50 && tableGenerator.getInitialValue() == 0;
    }

}
