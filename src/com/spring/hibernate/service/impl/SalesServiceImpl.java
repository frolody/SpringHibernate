/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.hibernate.service.impl;

import com.spring.hibernate.dao.SalesDao;
import com.spring.hibernate.entity.Sales;
import com.spring.hibernate.service.SalesService;
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
@Service("salesService")
@Transactional(readOnly = true)
public class SalesServiceImpl implements SalesService {

    @Autowired
    private SalesDao salesDao;

    @Transactional
    @Override
    public Sales save(Sales sales) {
        //agar tanggal yang digunakan adalah tanggal pada server kalau
        // dijalankan dengan arsitektur three tier
        sales.setSalesDate(new Date());
        return salesDao.save(sales);
    }

    @Transactional
    @Override
    public Sales delete(Sales sales) {
        return salesDao.delete(sales);
    }

    @Override
    public Sales getSales(Long id) {
        Sales s = salesDao.getById(id);
        Hibernate.initialize(s.getSalesDetails());
        return s;
    }

    @Override
    public List<Sales> getAll() {
        return salesDao.getAll();
    }

    @Override
    public List<Sales> getAll(int start, int num) {
        return salesDao.getAll(start, num);
    }
}
