/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.hibernate.service;

import java.util.Date;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Fadli Hudaya
 */
public interface ReportService {
    
    JasperPrint getDailySalesReport(Date date);
}
