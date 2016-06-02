package com.springapp.mvc.controller;

import com.springapp.mvc.dao.UserDAO;
import com.springapp.mvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/person")
public class UserController {

    private UserDAO userDAO;

    @Autowired
    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addPerson(Model model) {
        model.addAttribute("person", new User());
        return "add";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String savePerson(@Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("user");
            return "add";
        }
        if(userDAO.get(user.getUsername()) != null) {
            model.addAttribute("error", "Такой логин уже используется");
            //model.addAttribute("person");
            return "add";
        }
        userDAO.save(user);
        return "add";
    }

}
