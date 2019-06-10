/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.samples.petclinic.user;

import java.util.Collection;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface UserRepository extends Repository<User, Integer> {
    
    
    Collection<User> findAll();
    
    @Query("SELECT user FROM User user WHERE user.id = :id")
    @Transactional(readOnly = true)
    User findbyId(@Param("id") Integer id);
    
    @Transactional
    @Modifying
    @Query("DELETE FROM User user WHERE user.id = :id")
    void deleteUser(@Param("id") Integer id);
    
    
    void save(User user);

   
}