package org.personal.sample.domain;

import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import java.util.*;

@Entity
/*
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
*/
public class User {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String userName;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @OneToMany(cascade = CascadeType.PERSIST)
    //@ManyToMany
    @JoinTable( name = "User_Vehicle",
                joinColumns = @JoinColumn(name = "userId"),
                inverseJoinColumns = @JoinColumn(name = "vehicleId")
    )
    private Collection<Vehicle> vehicles = new ArrayList<Vehicle>();

    /*@ElementCollection
    @JoinTable(name = "Address",
        joinColumns = @JoinColumn(name = "userId")
    )

    //@GenericGenerator(name = "hilo-gen", strategy = "hilo")
    //@CollectionId(columns = @Column(name = "addressId"), type = @Type(type = "long"), generator = "hilo-gen")
    private Collection<Address> addresses = new ArrayList<Address>();
*/
    public User() {}

    public User(String userName, Date dateOfBirth){
        this.userName = userName;
        this.dateOfBirth = dateOfBirth;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /*public Collection<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Collection<Address> addresses) {
        this.addresses = addresses;
    }*/

    public Collection<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Collection<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
