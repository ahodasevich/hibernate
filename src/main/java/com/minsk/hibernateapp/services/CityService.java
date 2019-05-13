/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minsk.hibernateapp.services;

import com.minsk.hibernateapp.dao.CityDao;
import com.minsk.hibernateapp.entity.City;
import java.util.List;


public class CityService {
  private static CityDao cityDao;
 
    public CityService() {
        cityDao = new CityDao();
    }
 
    public void persist(City entity) {
        cityDao.openCurrentSessionwithTransaction();
        cityDao.persist(entity);
        cityDao.closeCurrentSessionwithTransaction();
    }
 
    public void update(City entity) {
        cityDao.openCurrentSessionwithTransaction();
        cityDao.update(entity);
        cityDao.closeCurrentSessionwithTransaction();
    }
 
    public City findById(int id) {
        cityDao.openCurrentSession();
        City city = cityDao.findById(id);
        cityDao.closeCurrentSession();
        return city;
    }
 
    public void delete(int id) {
        cityDao.openCurrentSessionwithTransaction();
        City city = cityDao.findById(id);
        cityDao.delete(city);
        cityDao.closeCurrentSessionwithTransaction();
    }
 
    public List<City> findAll() {
        cityDao.openCurrentSession();
        List<City> cities = cityDao.findAll();
        cityDao.closeCurrentSession();
        return cities;
    }
 
    public void deleteAll() {
        cityDao.openCurrentSessionwithTransaction();
        cityDao.deleteAll();
        cityDao.closeCurrentSessionwithTransaction();
    }
 
    public CityDao cityDao() {
        return cityDao;
    }  
}
