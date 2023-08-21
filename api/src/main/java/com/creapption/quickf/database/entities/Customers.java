package com.creapption.quickf.database.entities;

import org.springframework.data.annotation.Id;
import javax.persistence.*;
import java.util.Date;

public class Customers {
    public Customers(){

    }

    @Id
    @GeneratedValue
    public Long id;
    @Column(unique = true)
    public String identification;
    public String businessName;
    public Integer idType;
    public String phone;
    public Date birthday;
    public String address;
    public String email;
    public String comments;
    public boolean obligatedAccountability;
}
