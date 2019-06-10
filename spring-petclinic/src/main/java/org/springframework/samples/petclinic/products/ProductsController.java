
package org.springframework.samples.petclinic.products;

import java.util.Collection;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductsController {
      private final ProductRepository producto;
    
    public ProductsController(ProductRepository producto){
        this.producto =producto;
    }
    
    //Crear/agregar
    @GetMapping("/products/crearProductos")
    public  String initCreationForm(Map<String, Object> model){
    Products  producto = new Products();
    model.put("product",producto);
    return "products/crear";
    }
     //Listar
    @GetMapping("/products")
    public String ProductLista(Products products, BindingResult result, Map<String, Object> model){
        Collection<Products> results =this.producto.findAll();
        model.put("selections", results);
        return "products/lista";
        
    }
    //DELETE
    @PostMapping("/products/{idProducto}/delete")
    public String deleteProducto(@Valid Products producto, BindingResult result, @PathVariable ("idProducto") int id){
        this.producto.deleteProduct(id);
        return "redirect:/products";  
    }
    
    //SAVE
    @PostMapping("/products/guardarlos")
    public String ProcessCreationForm(@Valid Products producto, BindingResult result){
        this.producto.save(producto);
        return "redirect:/products";
    }
   
    
    //EDIT
   @GetMapping("/products/{idProducto}/edit")
    public String initUpdateProductForm(@PathVariable("idProducto") int idProducto, Model model) {
        Products producto = this.producto.findbyId(idProducto);
        model.addAttribute(producto);
        return "/products/edit"; 
    }
    @PostMapping("/products/{idProducto}/edit")
    public String processUpdateUserForm(@Valid Products products, BindingResult result, @PathVariable("idProducto") int idProducto) {
        if (result.hasErrors()) {
           return "redirect:/products";
        } else {
            products.setId(idProducto);
            this.producto.save(products);
            return "redirect:/products";
        }
 
    }
     
}
