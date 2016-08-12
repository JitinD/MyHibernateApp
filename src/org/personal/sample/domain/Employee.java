package org.personal.sample.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

@Entity
@Table(name = "employee")
public class Employee {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id")
    private int id;
    @Column(name = "emp_name", nullable = false)
    private String name;

    @Column(name = "emp_doj", nullable = false)
    private Date dateOfJoining;

    @Column(name = "employee_contact", length = 10, nullable = false, unique = true)
    private String contact;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "licence_id")
    private Licence licence;

    @ManyToOne
    @JoinColumn(name = "org_id")
    private Organization organization;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable( name = "emp_team_mapper",
                joinColumns = @JoinColumn(name = "emp_id"),
                inverseJoinColumns = @JoinColumn(name = "team_id"))
    private Collection<Team> teams = new HashSet<Team>();


    public Employee(){}

    public Employee(String name, String contact, Date dateOfJoining){
        this.name = name;
        this.contact = contact;
        this.dateOfJoining = dateOfJoining;
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

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }


    public Licence getLicence() {
        return licence;
    }

    public void setLicence(Licence licence) {
        this.licence = licence;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Collection<Team> getTeams() {
        return teams;
    }

    public void setTeams(Collection<Team> teams) {
        this.teams = teams;
    }
}
