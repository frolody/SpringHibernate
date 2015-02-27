/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.hibernate.service.impl;

import com.spring.hibernate.dao.MenuDao;
import com.spring.hibernate.dao.PersonDao;
import com.spring.hibernate.dao.RoleDao;
import com.spring.hibernate.entity.Menu;
import com.spring.hibernate.entity.Person;
import com.spring.hibernate.entity.Role;
import com.spring.hibernate.service.SecurityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Fadli Hudaya
 */
@Service("securityService")
@Transactional(readOnly = true)
public class SecurityServiceImpl implements SecurityService {

    @Autowired
    private PersonDao personDao;
    @Autowired
    private MenuDao menuDao;
    @Autowired
    private RoleDao roleDao;

    @Transactional
    @Override
    public Person save(Person person) {
        return personDao.save(person);
    }

    @Transactional
    @Override
    public Person delete(Person person) {
        return personDao.delete(person);
    }

    @Override
    public Person getPerson(Long id) {
        return personDao.getById(id);
    }

    @Override
    public List<Person> getPersons() {
        return personDao.getAll();
    }

    @Transactional
    @Override
    public Menu save(Menu menu) {
        return menuDao.save(menu);
    }

    @Transactional
    @Override
    public Menu delete(Menu menu) {
        return menuDao.delete(menu);
    }

    @Override
    public Menu getMenu(Long id) {
        return menuDao.getById(id);
    }

    @Override
    public List<Menu> getMenus() {
        return menuDao.getAll();
    }

    @Transactional
    @Override
    public Role save(Role role) {
        return roleDao.save(role);
    }

    @Transactional
    @Override
    public Role delete(Role role) {
        return roleDao.delete(role);
    }

    @Override
    public Role getRole(Long id) {
        return roleDao.getById(id);
    }

    @Override
    public List<Role> getRoles() {
        return roleDao.getAll();
    }
}
