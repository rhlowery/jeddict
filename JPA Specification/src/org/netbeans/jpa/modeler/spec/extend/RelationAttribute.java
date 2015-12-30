/**
 * Copyright [2014] Gaurav Gupta
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
package org.netbeans.jpa.modeler.spec.extend;

import java.util.ArrayList;
import java.util.List;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.DeclaredType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.netbeans.jpa.modeler.spec.AccessType;
import org.netbeans.jpa.modeler.spec.CascadeType;
import org.netbeans.jpa.modeler.spec.EmptyType;
import org.netbeans.jpa.modeler.spec.FetchType;
import org.netbeans.jpa.modeler.spec.JoinTable;
import org.netbeans.jpa.modeler.spec.jaxb.JaxbVariableType;
import org.netbeans.jpa.source.JavaSourceParserUtil;
import org.netbeans.modeler.core.NBModelerUtil;

/**
 *
 * @author Gaurav Gupta
 */
@XmlType(propOrder = {
    "joinTable",
    "cascade"
})
public abstract class RelationAttribute extends Attribute implements AccessTypeHandler, FetchTypeHandler {

    @XmlAttribute(name = "connected-entity-id", required = true)
    private String connectedEntityId;
    @XmlAttribute(name = "connected-attribute-id", required = true)
    private String connectedAttributeId;
    
    
     @XmlElement(name = "join-table")
    protected JoinTable joinTable;
    protected CascadeType cascade;
    @XmlAttribute(name = "target-entity")
    protected String targetEntity;
    @XmlAttribute(name = "fetch")
    protected FetchType fetch;
    
    @XmlAttribute(name = "access")
    protected AccessType access;
    
    public void load(AnnotationMirror relationAnnotationMirror, Element element, VariableElement variableElement) {
        this.setId(NBModelerUtil.getAutoGeneratedStringId());
        this.joinTable = JoinTable.load(element);
        List cascadeList = (List) JavaSourceParserUtil.findAnnotationValue(relationAnnotationMirror, "cascade");
        if (cascadeList != null) {
            CascadeType cascadeType = new CascadeType();
            this.cascade = cascadeType;
            for (Object cascadeObj : cascadeList) {
                if (cascadeObj.toString().equals("javax.persistence.CascadeType.ALL")) {
                    cascadeType.setCascadeAll(new EmptyType());
                } else if (cascadeObj.toString().equals("javax.persistence.CascadeType.PERSIST")) {
                    cascadeType.setCascadePersist(new EmptyType());
                } else if (cascadeObj.toString().equals("javax.persistence.CascadeType.MERGE")) {
                    cascadeType.setCascadeMerge(new EmptyType());
                } else if (cascadeObj.toString().equals("javax.persistence.CascadeType.REMOVE")) {
                    cascadeType.setCascadeMerge(new EmptyType());
                } else if (cascadeObj.toString().equals("javax.persistence.CascadeType.REFRESH")) {
                    cascadeType.setCascadeRefresh(new EmptyType());
                } else if (cascadeObj.toString().equals("javax.persistence.CascadeType.DETACH")) {
                    cascadeType.setCascadeDetach(new EmptyType());
                } else {
                    throw new IllegalStateException("Unknown Cascade Type : " + cascadeObj.toString());
                }
            }
        }

        this.name = variableElement.getSimpleName().toString();
        DeclaredType declaredType = (DeclaredType) JavaSourceParserUtil.findAnnotationValue(relationAnnotationMirror, "targetEntity");
        if (declaredType == null) { // Issue Fix #5925 Start
//            declaredType = (DeclaredType) variableElement.asType();
        String variable = variableElement.asType().toString();
 this.targetEntity = variable.substring(variable.lastIndexOf('.')+1,variable.length()-1); //java.util.Set<com.jpa.Entity1>
        } else {
                    this.targetEntity = declaredType.asElement().getSimpleName().toString();
        }
        this.fetch = FetchType.load(element, relationAnnotationMirror);
        this.access = AccessType.load(element);
        JavaSourceParserUtil.addNonEEAnnotation(this, element);
    }

    
    
    /**
     * Gets the value of the joinTable property.
     *
     * @return possible object is {@link JoinTable }
     *
     */
    public JoinTable getJoinTable() {
        if (joinTable == null) {
            joinTable = new JoinTable();
        }
        return joinTable;
    }

    /**
     * Sets the value of the joinTable property.
     *
     * @param value allowed object is {@link JoinTable }
     *
     */
    public void setJoinTable(JoinTable value) {
        this.joinTable = value;
    }

    /**
     * Gets the value of the cascade property.
     *
     * @return possible object is {@link CascadeType }
     *
     */
    public CascadeType getCascade() {
        return cascade;
    }

    /**
     * Sets the value of the cascade property.
     *
     * @param value allowed object is {@link CascadeType }
     *
     */
    public void setCascade(CascadeType value) {
        this.cascade = value;
    }



    /**
     * Gets the value of the targetEntity property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getTargetEntity() {
        return targetEntity;
    }

    /**
     * Sets the value of the targetEntity property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setTargetEntity(String value) {
        this.targetEntity = value;
    }

    /**
     * Gets the value of the fetch property.
     *
     * @return possible object is {@link FetchType }
     *
     */
    @Override
    public FetchType getFetch() {
        return fetch;
    }

    /**
     * Sets the value of the fetch property.
     *
     * @param value allowed object is {@link FetchType }
     *
     */
    @Override
    public void setFetch(FetchType value) {
        this.fetch = value;
    }


    /**
     * Gets the value of the access property.
     *
     * @return possible object is {@link AccessType }
     *
     */
    @Override
    public AccessType getAccess() {
        return access;
    }

    /**
     * Sets the value of the access property.
     *
     * @param value allowed object is {@link AccessType }
     *
     */
    @Override
    public void setAccess(AccessType value) {
        this.access = value;
    }

    

    /**
     * @return the connectedEntityId
     */
    public String getConnectedEntityId() {
        return connectedEntityId;
    }

    /**
     * @param connectedEntityId the connectedEntityId to set
     */
    public void setConnectedEntityId(String connectedEntityId) {
        this.connectedEntityId = connectedEntityId;
    }

    /**
     * @return the connectedAttributeId
     */
    public String getConnectedAttributeId() {
        return connectedAttributeId;
    }

    /**
     * @param connectedAttributeId the connectedAttributeId to set
     */
    public void setConnectedAttributeId(String connectedAttributeId) {
        this.connectedAttributeId = connectedAttributeId;
    }
  

    @Override
    public List<JaxbVariableType> getJaxbVariableList() {
        List<JaxbVariableType> jaxbVariableTypeList = new ArrayList<JaxbVariableType>();
        jaxbVariableTypeList.add(JaxbVariableType.XML_ELEMENT);
        jaxbVariableTypeList.add(JaxbVariableType.XML_TRANSIENT);
        return jaxbVariableTypeList;
    }  
}