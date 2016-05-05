//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2014.01.21 at 01:52:19 PM IST
//
package org.netbeans.jpa.modeler.spec;

import javax.lang.model.element.Element;
import javax.lang.model.element.VariableElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang.StringUtils;
import org.netbeans.jpa.modeler.spec.extend.AccessTypeHandler;
import org.netbeans.jpa.modeler.spec.extend.PersistenceBaseAttribute;
import org.netbeans.jpa.source.JavaSourceParserUtil;
import org.netbeans.modeler.core.NBModelerUtil;

/**
 *
 *
 * @Target({METHOD, FIELD}) @Retention(RUNTIME) public @interface Id {}
 *
 *
 *
 * <p>
 * Java class for id complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 *
 * <pre>
 * &lt;complexType name="id">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="column" type="{http://java.sun.com/xml/ns/persistence/orm}column" minOccurs="0"/>
 *         &lt;element name="generated-value" type="{http://java.sun.com/xml/ns/persistence/orm}generated-value" minOccurs="0"/>
 *         &lt;element name="temporal" type="{http://java.sun.com/xml/ns/persistence/orm}temporal" minOccurs="0"/>
 *         &lt;element name="table-generator" type="{http://java.sun.com/xml/ns/persistence/orm}table-generator" minOccurs="0"/>
 *         &lt;element name="sequence-generator" type="{http://java.sun.com/xml/ns/persistence/orm}sequence-generator" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="access" type="{http://java.sun.com/xml/ns/persistence/orm}access-type" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "id", propOrder = {
    "column",
    "generatedValue",
    "temporal",
    "tableGenerator",
    "sequenceGenerator"
})
public class Id extends PersistenceBaseAttribute implements AccessTypeHandler {

    protected Column column;
    @XmlElement(name = "generated-value")
    protected GeneratedValue generatedValue;
    protected TemporalType temporal;
    @XmlElement(name = "table-generator")
    protected TableGenerator tableGenerator;
    @XmlElement(name = "sequence-generator")
    protected SequenceGenerator sequenceGenerator;
    @XmlAttribute
    protected AccessType access;

    public static Id load(Element element, VariableElement variableElement) {
//        AnnotationMirror annotationMirror = JpaControllerUtil.findAnnotation(element, "javax.persistence.Basic");
        Id id = new Id();
        id.setId(NBModelerUtil.getAutoGeneratedStringId());
        id.column = Column.load(element);
        id.generatedValue = GeneratedValue.load(element, variableElement);
        id.temporal = TemporalType.load(element, variableElement);
        id.tableGenerator = TableGenerator.load(element);
        id.sequenceGenerator = SequenceGenerator.load(element);
        id.name = variableElement.getSimpleName().toString();
        id.access = AccessType.load(element);
        id.setAttributeType(variableElement.asType().toString());

        id.setAnnotation(JavaSourceParserUtil.getNonEEAnnotation(element));
        return id;
    }

    /**
     * Gets the value of the column property.
     *
     * @return possible object is {@link Column }
     *
     */
    @Override
    public Column getColumn() {
        if (column == null) {
            column = new Column();
        }
        return column;
    }

    /**
     * Sets the value of the column property.
     *
     * @param value allowed object is {@link Column }
     *
     */
    @Override
    public void setColumn(Column value) {
        this.column = value;
    }

    /**
     * Gets the value of the generatedValue property.
     *
     * @return possible object is {@link GeneratedValue }
     *
     */
    public GeneratedValue getGeneratedValue() {
        return generatedValue;
    }

    /**
     * Sets the value of the generatedValue property.
     *
     * @param value allowed object is {@link GeneratedValue }
     *
     */
    public void setGeneratedValue(GeneratedValue value) {
        this.generatedValue = value;
    }

    /**
     * Gets the value of the temporal property.
     *
     * @return possible object is {@link TemporalType }
     *
     */
    public TemporalType getTemporal() {
        return temporal;
    }

    /**
     * Sets the value of the temporal property.
     *
     * @param value allowed object is {@link TemporalType }
     *
     */
    public void setTemporal(TemporalType value) {
        this.temporal = value;
    }

    /**
     * Gets the value of the tableGenerator property.
     *
     * @return possible object is {@link TableGenerator }
     *
     */
    public TableGenerator getTableGenerator() {
        return tableGenerator;
    }

    /**
     * Sets the value of the tableGenerator property.
     *
     * @param value allowed object is {@link TableGenerator }
     *
     */
    public void setTableGenerator(TableGenerator value) {
        this.tableGenerator = value;
    }

    /**
     * Gets the value of the sequenceGenerator property.
     *
     * @return possible object is {@link SequenceGenerator }
     *
     */
    public SequenceGenerator getSequenceGenerator() {
        return sequenceGenerator;
    }

    /**
     * Sets the value of the sequenceGenerator property.
     *
     * @param value allowed object is {@link SequenceGenerator }
     *
     */
    public void setSequenceGenerator(SequenceGenerator value) {
        this.sequenceGenerator = value;
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

//    @Override
//    public List<JaxbVariableType> getJaxbVariableList(){
//       List<JaxbVariableType> jaxbVariableTypeList = super.getJaxbVariableList();
////                jaxbVariableTypeList.add(JaxbVariableType.);
//        return jaxbVariableTypeList;
//    }
    public String getReferenceColumnName() {
        Id id = this;
        if (id.getColumn() != null && StringUtils.isNotBlank(id.getColumn().getName())) {
            return id.getColumn().getName();
        } else {
            return id.getName();
        }
    }
}
