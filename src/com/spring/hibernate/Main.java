/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.hibernate;

import com.spring.hibernate.service.ProductService;
import com.spring.hibernate.service.ReportService;
import com.spring.hibernate.service.SalesService;
import com.spring.hibernate.service.SecurityService;
import com.spring.hibernate.view.MainFrame;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Fadli Hudaya
 */
public class Main {

    private static SecurityService securityService;
    private static ProductService productService;
    private static SalesService salesService;
    private static ReportService reportService;
    private static MainFrame frame;

    public static SecurityService getSecurityService() {
        return securityService;
    }

    public static ProductService getProductService() {
        return productService;
    }

    public static SalesService getSalesService() {
        return salesService;
    }

    public static ReportService getReportService() {
        return reportService;
    }
    
    public static MainFrame getMainFrame() {
        return frame;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ApplicationContext appContext = new ClassPathXmlApplicationContext("spring-ctx.xml");
        securityService = (SecurityService) appContext.getBean("securityService");
        productService = (ProductService) appContext.getBean("productService");
        salesService = (SalesService) appContext.getBean("salesService");
        reportService = (ReportService) appContext.getBean("reportService");
        frame = new MainFrame();
        frame.setVisible(true);
//        BarangService barangService = (BarangService) appContext.getBean("barangService");
//        Barang b = null;
//        for (int i = 0; i < 1000; i++) {
//            b = new Barang();
//            b.setNama_barang("Pepsodent " + i);
//            b.setHarga(i + 100);
//            barangService.save(b);
//        }
//
//        List<Barang> list = barangService.getBarang();
//        for (Barang barang : list) {
//            System.out.println("ID : " + barang.getId());
//            System.out.println("Nama : " + barang.getNama_barang());
//            System.out.println("Harga : " + String.valueOf(barang.getHarga()));
//        }
//        Configuration cfg = new Configuration().configure();
//        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
//        SessionFactory sessionFactory = cfg.buildSessionFactory(serviceRegistry);
//        
//        Barang barang = new Barang();
//        barang.setId(1l);
//        barang.setNama_barang("Acer 4732z");
//        barang.setHarga(50000);
//        
//        Session session = sessionFactory.openSession();
//        
//        try {
//            session.beginTransaction();
//            session.save(barang);
//            session.getTransaction().commit();
//        } catch (HibernateException e) {
//            System.out.println("Error" + e.getMessage());
//            session.getTransaction().rollback();
//        }
//        session.close();
//        
//        session = sessionFactory.openSession();
//        Query query = session.createQuery("from Barang");
//        List<Barang> list = query.list();
//        for(Barang b : list){
//            System.out.println("Id Barang : " + b.getId().toString());
//            System.out.println("Nama Barang :" + b.getNama_barang());
//            System.out.println("Harga : " + String.valueOf(b.getHarga()));
//        }
//        session.close();
//        sessionFactory.close();
    }

}
