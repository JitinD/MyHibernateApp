package org.personal.sample.domain;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "licence")
public class Licence {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "licence_id")
    private int id;
    @Column(name = "licence_number")
    private String number;
    private Date issuedDate;

    public Licence(){}

    public Licence(String number, Date issuedDate){
        this.number = number;
        this.issuedDate = issuedDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

}
