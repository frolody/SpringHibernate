/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.hibernate.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Fadli Hudaya
 */
@Entity
@Table(name = "T_PRODUCT")
public class Product implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "NAME", length = 50)
    private String name;
    
    @Column(name = "PRICE")
    private BigDecimal price;

    public Long getId() {
        return id;
    }   

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nama_barang) {
        this.name = nama_barang;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal harga) {
        this.price = harga;
    }
    
}
