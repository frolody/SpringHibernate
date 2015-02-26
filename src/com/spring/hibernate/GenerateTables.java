/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.hibernate;

import com.spring.hibernate.service.SecurityService;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Fadli Hudaya
 */
public class GenerateTables {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        AbstractApplicationContext appContext = new ClassPathXmlApplicationContext("spring-ctx.xml");
        DataSource dataSource = (DataSource) appContext.getBean("dataSource");
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        Connection con = dataSource.getConnection();
        new SchemaExport(cfg, con).create(true, true);
        SecurityService securityService = (SecurityService) appContext.getBean("securityService");
        System.exit(0);
    }
    
}
