/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.hibernate.service;

import com.spring.hibernate.entity.Product;
import java.util.List;

/**
 *
 * @author Fadli Hudaya
 */
public interface ProductService {

    void save(Product product);
    void delete(Product product);
    Product getProduct(Long id);
    List<Product> getAll();
    List<Product> getAll(int start, int num);
}
