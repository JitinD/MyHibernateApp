package org.personal.sample.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

@Entity
@Table(name = "organization")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "org_id")
    private int id;
    @Column(name = "org_name")
    private String name;

    @Column(name = "org_location")
    private String location;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "organization")
    /*@JoinTable( name = "org_emp_mapper",
                joinColumns = @JoinColumn(name = "org_id"),
                inverseJoinColumns = @JoinColumn(name = "emp_id"))
    */private Collection<Employee> employees = new HashSet<Employee>();

    public Organization(){}

    public Organization(String name, String location){
        this.name = name;
        this.location = location;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Collection<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Collection<Employee> employees) {
        this.employees = employees;
    }
}
