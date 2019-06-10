package org.springframework.samples.petclinic.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    private final UserRepository user;

    public UserController(UserRepository user) {
        this.user = user;
    }

    @GetMapping("/user")
    public String user(Map<String, Object>model) {
        Collection<User> result = this.user.findAll();
        model.put("selections", result);
        return "user/user";
    }

   @GetMapping("/user/new")
    public String newuser(Map<String, Object> model) {
        User user = new User();
        model.put("user", user);
        return "user/usereditcreate";
    }

    @PostMapping("/user/new")
    public String usercreate(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "user/usereditcreate";
        } else {
            this.user.save(user);
            return "redirect:/user";
        }
    }
    
    
   @GetMapping("/user/{idUser}/edit")
    public String initUpdateUserForm(@PathVariable("idUser") int idUser, Model model) {
       User user = this.user.findbyId(idUser);
        model.addAttribute(user);
        return "/user/userEdit";
    }
    
    @PostMapping("/user/{idUser}/edit")
      public String processUpdateUserForm(@Valid User user, BindingResult result, @PathVariable("idUser") int idUser) {
        if (result.hasErrors()) {
            return "redirect:/user";
        } else {
            user.setId(idUser);
            this.user.save(user);
            return "redirect:/user";
        }
    }
      
      @PostMapping("/user/{idUser}/delete")
      public String deleteUser(@Valid User user, BindingResult result , @PathVariable("idUser") int id){
          this.user.deleteUser(id);
          return "redirect:/user";
      } 

}