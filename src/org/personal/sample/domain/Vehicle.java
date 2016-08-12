package org.personal.sample.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "ClassName")
public class Vehicle {

    @Id @GeneratedValue(strategy = GenerationType.TABLE)
    private int vehicleId;
    private String vehicleName;

    //@ManyToOne
    //@JoinColumn(name = "userId")
    //@ManyToMany(mappedBy = "vehicles")
    //private Collection<User> users = new ArrayList<User>();

    public Vehicle(){}

    public Vehicle(String vehicleName){
        this.vehicleName = vehicleName;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    /*public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }*/
}
