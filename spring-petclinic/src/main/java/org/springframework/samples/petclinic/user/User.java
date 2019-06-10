package org.springframework.samples.petclinic.user;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.xml.bind.annotation.XmlElement;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.core.style.ToStringCreator;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.model.Person;

import javax.persistence.Entity;

import javax.persistence.Table;

import javax.persistence.Column;

import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "user")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
    public Integer getId(){
        return id;
    }
    
    public void setId(Integer id){
        this.id = id;
    }
    
    public boolean isNew(){
        return this.id == null;
    }
    
   
	@Column(name = "username")
        @NotEmpty
	private String userName;
	
	@Column(name = "lastname")  
        @NotEmpty
	private String lastName;
        
        @Column(name = "email")
        @NotEmpty
        private String email;
        
        @Column (name = "password")
        @NotEmpty
        private String password;
        
        @Column (name = "estatus")
        @NotEmpty
        private String estatus;      
        
        @Column (name ="imagen")
        @NotEmpty
        private String imagen;


        public String getImagen() {
            return imagen;
        }

        public void setImagen(String imagen) {
            this.imagen = imagen;
        }
        
        public String getEstatus() {
            return estatus;
        }

        public void setEstatus(String estatus) {
            this.estatus = estatus;
        }
       
        
        public void setUserName(String username){
            this.userName = username;
        }
        
        public String getUserName(){
            return userName;
        }
        
        public void setLastName(String lastname){
            this.lastName = lastname;
        }
        
        public String getLastName(){
            return lastName;
        }
        
        public void setEmail(String email){
            this.email = email;
        }
        
        public String getEmail(){
            return email;
        }
        
        public void setPassword(String password){
            this.password = password;
        }
        
        public String getPassword(){
            return password;
        }
        
     
        
        
   @Override
    public String toString(){
        return new ToStringCreator(this)
                .append("id", this.getId()).append("new", this.isNew())
                .append("userName", this.getUserName())
                .append("lastname", this.getLastName())
                .append("password", this.getPassword())
                .append("email", this.getEmail())
                .append("imagen", this.getImagen())
                .append("estatus", this.getEstatus()).toString();
    }

   
    
}