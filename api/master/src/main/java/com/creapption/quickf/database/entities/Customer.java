package com.creapption.quickf.database.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Customer {
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
