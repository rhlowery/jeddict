/**
 * This file was generated by the JPA Modeler
 */
package io.github.jeddict.jnosql.employee;

import org.jnosql.artemis.Entity;
import org.jnosql.artemis.Id;

@Entity("Cubicle")
public class Cubicle {

    @Id("id")
    private Long id;

    private String displayNumber;

    private Employee residentEmployee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDisplayNumber() {
        return displayNumber;
    }

    public void setDisplayNumber(String displayNumber) {
        this.displayNumber = displayNumber;
    }

    public Employee getResidentEmployee() {
        return residentEmployee;
    }

    public void setResidentEmployee(Employee residentEmployee) {
        this.residentEmployee = residentEmployee;
    }

}