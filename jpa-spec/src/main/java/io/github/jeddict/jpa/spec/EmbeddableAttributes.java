//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2014.01.21 at 01:52:19 PM IST
//
package io.github.jeddict.jpa.spec;

import static io.github.jeddict.jcode.JPAConstants.BASIC_FQN;
import static io.github.jeddict.jcode.JPAConstants.ELEMENT_COLLECTION_FQN;
import static io.github.jeddict.jcode.JPAConstants.EMBEDDED_FQN;
import static io.github.jeddict.jcode.JPAConstants.MANY_TO_MANY_FQN;
import static io.github.jeddict.jcode.JPAConstants.MANY_TO_ONE_FQN;
import static io.github.jeddict.jcode.JPAConstants.ONE_TO_MANY_FQN;
import static io.github.jeddict.jcode.JPAConstants.ONE_TO_ONE_FQN;
import static io.github.jeddict.jcode.JPAConstants.TRANSIENT_FQN;
import io.github.jeddict.jpa.spec.extend.Attribute;
import io.github.jeddict.jpa.spec.extend.PersistenceAttributes;
import io.github.jeddict.jpa.spec.workspace.WorkSpace;
import io.github.jeddict.source.ClassExplorer;
import io.github.jeddict.source.JavaSourceParserUtil;
import static io.github.jeddict.source.JavaSourceParserUtil.getElements;
import io.github.jeddict.source.MemberExplorer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import static java.util.Objects.nonNull;
import java.util.Optional;
import java.util.function.Predicate;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.eclipse.persistence.internal.jpa.metadata.accessors.classes.XMLAttributes;

/**
 * <p>
 * Java class for embeddable-attributes complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 *
 * <pre>
 * &lt;complexType name="embeddable-attributes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="basic" type="{http://java.sun.com/xml/ns/persistence/orm}basic" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="many-to-one" type="{http://java.sun.com/xml/ns/persistence/orm}many-to-one" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="one-to-many" type="{http://java.sun.com/xml/ns/persistence/orm}one-to-many" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="one-to-one" type="{http://java.sun.com/xml/ns/persistence/orm}one-to-one" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="many-to-many" type="{http://java.sun.com/xml/ns/persistence/orm}many-to-many" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="element-collection" type="{http://java.sun.com/xml/ns/persistence/orm}element-collection" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="embedded" type="{http://java.sun.com/xml/ns/persistence/orm}embedded" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="transient" type="{http://java.sun.com/xml/ns/persistence/orm}transient" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "embeddable-attributes", propOrder = {})
public class EmbeddableAttributes extends PersistenceAttributes<Embeddable> {

    @Override
    public void load(ClassExplorer clazz) {
        Collection<MemberExplorer> members = clazz.getMembers();

        for (MemberExplorer member : members) {
            if (member.isAnnotationPresent(javax.persistence.Basic.class)) {
                this.findBasic(member.getFieldName())
                        .orElseGet(() -> {
                            Basic basic = new Basic();
                            this.addBasic(basic);
                            return basic;
                        }).load(member);
            } else if (member.isAnnotationPresent(javax.persistence.Transient.class)) {
                this.findTransient(member.getFieldName())
                        .orElseGet(() -> {
                            Transient _transient = new Transient();
                            this.addTransient(_transient);
                            return _transient;
                        }).load(member);
            } else if (member.isAnnotationPresent(javax.persistence.ElementCollection.class)) {
                Optional<ElementCollection> elementCollectionOpt = this.findElementCollection(member.getFieldName());
                if (elementCollectionOpt.isPresent()) {
                    ElementCollection.load(elementCollectionOpt.get(), member);
                } else {
                    ElementCollection elementCollection = ElementCollection.load(new ElementCollection(), member);
                    if (nonNull(elementCollection)) {
                        this.addElementCollection(elementCollection);
                    }
                }
            } else if (member.isAnnotationPresent(javax.persistence.OneToOne.class)) {
                this.findOneToOne(member.getFieldName())
                        .orElseGet(() -> {
                            OneToOne oneToOneObj = new OneToOne();
                            this.addOneToOne(oneToOneObj);
                            return oneToOneObj;
                        }).load(member);
            } else if (member.isAnnotationPresent(javax.persistence.ManyToOne.class)) {
                this.findManyToOne(member.getFieldName())
                        .orElseGet(() -> {
                            ManyToOne manyToOneObj = new ManyToOne();
                            this.addManyToOne(manyToOneObj);
                            return manyToOneObj;
                        }).load(member);
            } else if (member.isAnnotationPresent(javax.persistence.OneToMany.class)) {
                this.findOneToMany(member.getFieldName())
                        .orElseGet(() -> {
                            OneToMany oneToMany = new OneToMany();
                            this.addOneToMany(oneToMany);
                            return oneToMany;
                        }).load(member);
            } else if (member.isAnnotationPresent(javax.persistence.ManyToMany.class)) {
                this.findManyToMany(member.getFieldName())
                        .orElseGet(() -> {
                            ManyToMany manyToMany = new ManyToMany();
                            this.addManyToMany(manyToMany);
                            return manyToMany;
                        }).load(member);
            } else if (member.isAnnotationPresent(javax.persistence.Embedded.class)) {
                Optional<Embedded> embeddedOpt = this.findEmbedded(member.getFieldName());
                if (embeddedOpt.isPresent()) {
                    Embedded.load(embeddedOpt.get(), member);
                } else {
                    Embedded embedded = Embedded.load(new Embedded(), member);
                    if (nonNull(embedded)) {
                        this.addEmbedded(embedded);
                    }
                }
            } else {
                this.findBasic(member.getFieldName()) //Default Annotation
                        .orElseGet(() -> {
                            Basic basic = new Basic();
                            this.addBasic(basic);
                            return basic;
                        }).load(member);
            }
        }
    }

    @Override
    public XMLAttributes getAccessor(WorkSpace workSpace) {
        XMLAttributes attr = super.getAccessor(workSpace);
        attr.setIds(new ArrayList<>());
        attr.setVersions(new ArrayList<>());
        return updateAccessor(workSpace, attr);
    }

    @Override
    public XMLAttributes getAccessor(WorkSpace workSpace, boolean inherit) {//inherit not supported
        XMLAttributes attr = super.getAccessor(workSpace);
        return attr;
    }

    public XMLAttributes updateAccessor(WorkSpace workSpace, XMLAttributes attr) {
        super.updateAccessor(workSpace, attr, false);
        return attr;
    }

    public static List<String> getPaths(String prefix, Embedded embedded, Predicate<Attribute> filter) {
        final String leafPrefix = prefix.isEmpty() ? embedded.getName() : (prefix + '.' + embedded.getName());
        List<Attribute> attributes = embedded.getConnectedClass().getAttributes().getAllAttribute(true);
        List<String> paths = attributes.stream()
                .filter(attr -> attr instanceof Embedded)
                .map(attr -> (Embedded) attr)
                .map(emb -> getPaths(leafPrefix, emb, filter))
                .collect(ArrayList<String>::new, ArrayList::addAll, ArrayList::addAll);
        paths.addAll(attributes.stream()
                .filter(filter)
                .map(Attribute::getName)
                .map(leaf -> leafPrefix + '.' + leaf)
                .collect(ArrayList<String>::new, ArrayList::add, ArrayList::addAll));
        return paths;
    }

}
