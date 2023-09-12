package com.creapption.quickf.database.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Company {
    @Id
    @GeneratedValue
    public Long id;

    public String name;
    public String ruc;
}
