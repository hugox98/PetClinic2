/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.samples.petclinic.products;


import java.util.Collection;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface ProductRepository extends Repository<Products, Integer> {

    @Transactional(readOnly = true)
    Collection<Products> findAll()throws DataAccessException;
    
   
    @Query("SELECT product FROM Products product where product.id = :id")
    @Transactional(readOnly = true)
    Products findbyId(@Param("id") Integer id);
   
   
    @Transactional
    @Modifying
    @Query("DELETE FROM Products product where product.id = :id")
    void deleteProduct(@Param("id")  Integer id);
    
    void save(Products product);
    
}
