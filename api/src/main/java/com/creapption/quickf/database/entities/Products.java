package com.creapption.quickf.database.entities;

import org.springframework.data.annotation.Id;
import javax.persistence.GeneratedValue;

public class Products {
    public Products(){

    }

    @Id
    @GeneratedValue
    public Long id;

    public String code;
    public String description;
    public Integer quantity;
    public Double costPrice;
    public String brand;
}
