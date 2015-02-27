/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.hibernate.service.impl;

import com.spring.hibernate.report.DailySalesReport;
import com.spring.hibernate.service.ReportService;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Fadli Hudaya
 */
@Service("reportService")
@Transactional(readOnly = true)
public class ReportServiceImpl implements ReportService {

    private static final Logger log = Logger.getLogger(ReportServiceImpl.class);
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public JasperPrint getDailySalesReport(Date date) {
        try {
            List<DailySalesReport> list = sessionFactory.getCurrentSession()
                    .createQuery("SELECT s.product.name AS productName, SUM(s.quantity) AS quantity,"
                            + " SUM(s.subtotal) AS subtotal FROM SalesDetail s WHERE DAY(s.sales.salesDate)"
                            + "=DAY(:date) GROUP BY s.product.name ORDER BY s.product.name")
                    .setParameter("date", date)
                    .setResultTransformer(Transformers.aliasToBean(DailySalesReport.class)).list();
            InputStream is = ReportServiceImpl.class.getResourceAsStream("/reports/DailySalesReport.jasper");
            Map<String, Object> param = new HashMap<>();
            param.put("date", date);
            for (int i = 0; i < list.size(); i++) {
                DailySalesReport d = list.get(i);
                System.out.println("Nama Produk : " + d.getProductName());
                System.out.println("Kuantitas : " + d.getQuantity());
                System.out.println("Subtotal : " + d.getSubtotal());
            }
            return JasperFillManager.fillReport(is, param, new JRBeanCollectionDataSource(list));
        } catch (JRException e) {
            log.error("Error Generate Daily Sales Report ", e);
            return null;
        }
    }

}
