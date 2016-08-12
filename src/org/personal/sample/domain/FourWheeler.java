package org.personal.sample.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Car")
public class FourWheeler extends Vehicle {

    private String steeringWheel;

    public FourWheeler(){}

    public FourWheeler(String vehicleName, String steeringWheel){
        this.setVehicleName(vehicleName);
        this.steeringWheel = steeringWheel;
    }

    public String getSteeringWheel() {
        return steeringWheel;
    }

    public void setSteeringWheel(String steeringWheel) {
        this.steeringWheel = steeringWheel;
    }
}
