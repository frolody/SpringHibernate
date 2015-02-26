/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.hibernate.service;

import com.spring.hibernate.entity.Menu;
import com.spring.hibernate.entity.Person;
import com.spring.hibernate.entity.Role;
import java.util.List;

/**
 *
 * @author Fadli Hudaya
 */
public interface SecurityService {
    
    public void save(Person person);
    public void delete(Person person);
    public Person getPerson(Long id);
    public List<Person> getPersons();
    
    public void save(Menu menu);
    public void delete(Menu menu);
    public Menu getMenu(Long id);
    public List<Menu> getMenus();
    
    public void save(Role role);
    public void delete(Role role);
    public Role getRole(Long id);
    public List<Role> getRoles();
}
