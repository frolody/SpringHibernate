/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.hibernate.service.impl;

import com.spring.hibernate.dao.PurchaseDao;
import com.spring.hibernate.entity.Purchase;
import com.spring.hibernate.service.PurchaseService;
import java.util.Date;
import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Fadli Hudaya
 */
@Service("purchaseService")
@Transactional(readOnly = true)
public class PurchaseServiceImpl implements PurchaseService{

    @Autowired
    private PurchaseDao purchaseDao;
    
    @Transactional
    @Override
    public Purchase save(Purchase purchase) {
        purchase.setPurchaseDate(new Date());
        return purchaseDao.save(purchase);
    }

    @Override
    public Purchase delete(Purchase purchase) {
        return purchaseDao.delete(purchase);
    }

    @Override
    public Purchase getById(Long id) {
        Purchase p = purchaseDao.getById(id);
        Hibernate.initialize(p.getPurchaseDetail());
        return p;
    }

    @Override
    public List<Purchase> getAll() {
        return purchaseDao.getAll();
    }

    @Override
    public List<Purchase> getAll(int start, int num) {
        return purchaseDao.getAll(start, num);
    }
    
}
