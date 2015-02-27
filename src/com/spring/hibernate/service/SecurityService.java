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
    
    public Person save(Person person);
    public Person delete(Person person);
    public Person getPerson(Long id);
    public List<Person> getPersons();
    
    public Menu save(Menu menu);
    public Menu delete(Menu menu);
    public Menu getMenu(Long id);
    public List<Menu> getMenus();
    
    public Role save(Role role);
    public Role delete(Role role);
    public Role getRole(Long id);
    public List<Role> getRoles();
}
