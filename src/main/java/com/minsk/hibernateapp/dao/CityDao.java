/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minsk.hibernateapp.dao;

import com.minsk.hibernateapp.entity.City;
import com.minsk.hibernateapp.entity.Country;
import java.util.List;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class CityDao implements CityDaoInterface<City, Integer> {

  private Session currentSession;
     
    private Transaction currentTransaction;

    public CityDao() {
    }
    
   public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }
 
    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }
     
    public void closeCurrentSession() {
        currentSession.close();
    }
     
    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }
     
    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(City.class);
        configuration.addAnnotatedClass(Country.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }
 
    public Session getCurrentSession() {
        return currentSession;
    }
 
    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }
 
    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }
 
    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }
 
    public void persist(City entity) {
        getCurrentSession().save(entity);
    }
 
    public void update(City entity) {
        getCurrentSession().update(entity);
    }
 
    public City findById(Integer id) {
        City city = (City) getCurrentSession().get(City.class, id);
        return city; 
    }
 
    public void delete(City entity) {
        getCurrentSession().delete(entity);
    }
 
    @SuppressWarnings("unchecked")
    public List<City> findAll() {
        List<City> cities = (List<City>) getCurrentSession().createQuery("from City").list();
        return cities;
    }
 
    public void deleteAll() {
        List<City> entityList = findAll();
        for (City entity : entityList) {
            delete(entity);
        }
    }
}    
    

