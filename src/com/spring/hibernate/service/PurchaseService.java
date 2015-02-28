/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.hibernate.service;

import com.spring.hibernate.entity.Purchase;
import java.util.List;

/**
 *
 * @author Fadli Hudaya
 */
public interface PurchaseService {
    
    Purchase save(Purchase purchase);
    Purchase delete(Purchase purchase);
    Purchase getById(Long id);
    List<Purchase> getAll();
    List<Purchase> getAll(int start, int num);
    
}
