/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.hibernate.service;

import com.spring.hibernate.entity.Sales;
import java.util.List;

/**
 *
 * @author Fadli Hudaya
 */
public interface SalesService {
    
    void save(Sales sales);
    void delete(Sales sales);
    Sales getSales(Long id);
    List<Sales> getAll();
    List<Sales> getAll(int start, int num);
}
