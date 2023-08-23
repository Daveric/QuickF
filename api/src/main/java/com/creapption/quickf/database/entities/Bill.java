package com.creapption.quickf.database.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Bill {
    @Id
    @GeneratedValue
    public Long id;
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    public Customer customerId;
    public Date emissionDate;
    public String iva;
    public Float totalWithoutTaxes;
    public Float totalDiscounts;
    public Float total;
    public String currency;
}
