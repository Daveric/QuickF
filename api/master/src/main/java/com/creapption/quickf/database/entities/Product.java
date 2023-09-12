package com.creapption.quickf.database.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue
    public Long id;
    public String code;
    public String description;
    public Integer quantity;
    public Double costPrice;
    public String brand;
}
