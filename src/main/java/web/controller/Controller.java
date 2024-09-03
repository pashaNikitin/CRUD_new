package web.controller;//package org.example.controller;
//
//import org.example.model.User;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//
//@org.springframework.stereotype.Controller("Controller")
//@RequestMapping("/")
//public class Controller {
//
//    @GetMapping("")
//    public String test2() {
//        return "hello";
//    }
//    @GetMapping("/page1")
//    public String test3() {
//    return "page1";
//    }
//}
//package org.example.controller;
//
//import org.example.model.User;
//import org.example.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//        import java.util.List;
//
//@Controller
//@RequestMapping("/")
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    // Показать список пользователей
//    @GetMapping("")
//    public String listUsers(Model model) {
//        List<User> users = userService.getAll();
//        model.addAttribute("users", users);
//        return "user-list";
//    }
//
//    // Показать форму для добавления нового пользователя
//    @GetMapping("/new")
//    public String showCreateForm(Model model) {
//        model.addAttribute("user", new User());
//        return "user-form";
//    }
//
//    // Сохранить нового пользователя
//    @PostMapping
//    public String saveUser(@ModelAttribute("user") User user) {
//        userService.save(user);
//        return "redirect:/users";
//    }
//
//    // Показать форму для редактирования пользователя
//    @GetMapping("/edit/{id}")
//    public String showUpdateForm(@PathVariable("id") int id, Model model) {
//        User user = userService.getById(id);
//        model.addAttribute("user", user);
//        return "user-form";
//    }
//
//    // Обновить данные пользователя
//    @PostMapping("/update/{id}")
//    public String updateUser(@PathVariable("id") int id, @ModelAttribute("user") User user) {
//        user.setId(id);
//        userService.update(user);
//        return "redirect:/users";
//    }
//
//    // Удалить пользователя
//    @GetMapping("/delete/{id}")
//    public String deleteUser(@PathVariable("id") int id) {
//        userService.delete(id);
//        return "redirect:/users";
//    }
//}