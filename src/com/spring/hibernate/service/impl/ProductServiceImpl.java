/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.hibernate.service.impl;

import com.spring.hibernate.dao.ProductDao;
import com.spring.hibernate.entity.Product;
import com.spring.hibernate.service.ProductService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Fadli Hudaya
 */
@Service("productService")
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductDao productDao;
    
    @Transactional
    @Override
    public void save(Product product) {
        productDao.save(product);
    }

    @Transactional
    @Override
    public void delete(Product product) {
        productDao.delete(product);
    }

    @Override
    public Product getProduct(Long id) {
        return productDao.getById(id);
    }

    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public List<Product> getAll(int start, int num) {
        return productDao.getAll(start, num);
    }
}
