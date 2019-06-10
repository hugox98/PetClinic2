/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.samples.petclinic.products;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import org.springframework.core.style.ToStringCreator;

@Entity
@Table(name="products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isNew() {
        return this.id == null;
    }
    @Column(name = "nombre")
    @NotEmpty
    private String nombre;

    @Column(name = "precio")
    @NotEmpty
    private String precio;

    @Column(name = "descripcion")
    @NotEmpty
    private String descripcion;
    
     @Column(name = "imagen")
    private String imagen;


    @Column(name = "cantidad")
    @NotEmpty
    private String cantidad;

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    




    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("id", this.getId()).append("new", this.isNew())
                .append("nombre", this.getNombre())
                .append("precio", this.getPrecio())
                .append("descripcion", this.getDescripcion())
                .append("cantidad",this.getCantidad())
                .append("imagen",this.getImagen())
                .toString();
    }
    
}
