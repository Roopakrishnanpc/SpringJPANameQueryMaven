package com.SpringJPADemoMaven.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.SpringJPADemoMaven.Entity.User;
import com.SpringJPADemoMaven.Service.UserService;

@Controller
//@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;
	@RequestMapping("/")
	public String home()
	{
		System.out.println("Home page requested");
		//return "index";
		
		return "index";
	}
    @GetMapping
    public String listUsers(Model model) {
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("user", new User());
        return "createUser";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Optional<User> user = userService.findUserById(id);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
            return "editUser";
        } else {
            model.addAttribute("errorMessage", "User not found");
            return "error";
        }
    }

    @PostMapping("/edit")
    public String updateUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/user/edit")
    public String redirectToEditForm(@RequestParam("userId") Long userId) {
        return "redirect:/edit/" + userId;
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping("/findByName")
    public String findUserByName(@RequestParam("name") String name, Model model) {
        List<User> users = userService.findUsersByUsername(name);
        model.addAttribute("users", users);
        return "userDetails";
    }

    @GetMapping("/findByEmail")
    public String findUserByEmail(@RequestParam("email") String email, Model model) {
        List<User> users = userService.findUsersByEmail(email);
        model.addAttribute("users", users);
        return "userDetails";
    }
}
