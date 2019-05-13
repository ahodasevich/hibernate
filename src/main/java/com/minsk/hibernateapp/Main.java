/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minsk.hibernateapp;

import com.minsk.hibernateapp.entity.City;
import com.minsk.hibernateapp.services.CityService;
import com.minsk.hibernateapp.entity.Country;
import com.minsk.hibernateapp.services.CountryService;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Main {

    public static void main(String[] args) {

        CountryService countryService = new CountryService();
        CityService cityService = new CityService();
        Country country = new Country("BB", "Belarus", "Europe", "E.Europe", 10000, 9000000);
        countryService.persist(country);
        City city1 = new City("City1", "Minskiy", 30000);
        city1.setCountry(country);
        country.addCity(city1);
        System.out.println(country);
        System.out.println(city1);
        countryService.update(country);

        /*
       List<Country> list = countryService.findAll();
       for (Country l: list){
             System.out.println(l);
         } 
       */
    }

}
