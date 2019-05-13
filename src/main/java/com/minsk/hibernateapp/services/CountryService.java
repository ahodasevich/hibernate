/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minsk.hibernateapp.services;

import com.minsk.hibernateapp.dao.CountryDao;
import com.minsk.hibernateapp.entity.City;
import com.minsk.hibernateapp.entity.Country;
import java.util.List;


public class CountryService {
  private static CountryDao countryDao;
 
    public CountryService() {
        countryDao = new CountryDao();
    }
 
    public void persist(Country entity) {
        countryDao.openCurrentSessionwithTransaction();
        countryDao.persist(entity);
        countryDao.closeCurrentSessionwithTransaction();
    }
 
    public void update(Country entity) {
        countryDao.openCurrentSessionwithTransaction();
        countryDao.update(entity);
        countryDao.closeCurrentSessionwithTransaction();
    }
 
    public Country findById(int id) {
        countryDao.openCurrentSession();
        Country country = countryDao.findById(id);
        countryDao.closeCurrentSession();
        return country;
    }
 
    public void delete(int id) {
        countryDao.openCurrentSessionwithTransaction();
        Country country = countryDao.findById(id);
        countryDao.delete(country);
        countryDao.closeCurrentSessionwithTransaction();
    }
 
    public List<Country> findAll() {
        countryDao.openCurrentSession();
        List<Country> countries = countryDao.findAll();
        countryDao.closeCurrentSession();
        return countries;
    }
 
    public void deleteAll() {
        countryDao.openCurrentSessionwithTransaction();
        countryDao.deleteAll();
        countryDao.closeCurrentSessionwithTransaction();
    }
 
        public void addListCities(List<City> cities) {
        countryDao.openCurrentSessionwithTransaction();
     //   countryDao.addListCities(cities);
        countryDao.closeCurrentSessionwithTransaction();
    }
    
    public CountryDao countryDao() {
        return countryDao;
    }  
}
