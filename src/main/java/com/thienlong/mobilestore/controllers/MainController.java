package com.thienlong.mobilestore.controllers;

import com.thienlong.mobilestore.entity.Product;
import com.thienlong.mobilestore.entity.Userss;
import com.thienlong.mobilestore.repository.UserRepository;
import com.thienlong.mobilestore.service.IProductService;
import com.thienlong.mobilestore.service.IUserService;
import com.thienlong.mobilestore.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IProductService productService;

    // WELCOME PAGE
    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String indexPage(Model model) {
        model.addAttribute("message", "This is welcome page!");
        return "index";
    }
    //-----------------------------------------------------------------

    //LOGIN
    //    @PostMapping("/loginUser")
//    public String loginUser(@ModelAttribute("user") Userss userss) {
//        String userName = userss.getUserName();
//        Optional<Userss> userData = Optional.ofNullable(userRepo.findByUserName(userName));
//        if (userss.getPassword().equals(userData.get().getPassword())) {
//            return "redirect:/adminPage";
//        } else {
//            return "error";
//        }
//    }
    // LOGIN WITH SECURITY
//    @GetMapping("/login")
//    public String loginPage() {
//        return "login";
//    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
        return "login";
    }
    //-----------------------------------------------------------------


    // LOGOUT
    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        return "redirect:/index";
    }
    //-----------------------------------------------------------

    // ADMIN PAGE without Security
//    @RequestMapping("/adminPage")
//    public String index(Model model) {
//        List<User> users = userService.findAll();
//        model.addAttribute("users", users);
//        return "adminPage";
//    }
    // ADMIN PAGE with Security
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model, Principal principal) {
        User loginUsers = (User) ((Authentication) principal).getPrincipal();
        String userInfo = WebUtils.toString(loginUsers);
        model.addAttribute("adminInfo", userInfo);
        List<Userss> user = userService.findAll();
        model.addAttribute("users", user);
        return "adminPage";
    }
    // --------------------------------------------------------------------------

    // User Infomation Page
    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {
        String userName = principal.getName();
        User loginUser = (User) ((Authentication) principal).getPrincipal();
        String userInfo = WebUtils.toString(loginUser);
        model.addAttribute("userInfo", userInfo);
        List<Product> product = productService.findAll();
        model.addAttribute("products", product);
        return "userPage";
    }
    // --------------------------------------------------------------------------

    // ERROR PAGE
    @RequestMapping(value = "/403Page", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {
        if (principal != null) {
            User loginUser = (User) ((Authentication) principal).getPrincipal();
            String userInfo = WebUtils.toString(loginUser);
            model.addAttribute("userInfo", userInfo);
            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);
        }
        return "403Page";
    }
    // --------------------------------------------------------------------------

    // FUNCTION CRUD
    @RequestMapping(value = "/add")
    public String addUser(Model model) {
        model.addAttribute("users", new Userss());
        return "createUser";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(Userss userss) {
        userService.save(userss);
        return "redirect:admin";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateUser(@RequestParam("id") Integer ID, Model model) {
        Optional<Userss> userUpdate = userService.findByID(ID);
        userUpdate.ifPresent(user -> model.addAttribute("users", user));
        return "updateUser";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteUser(@RequestParam("id") Integer ID, Model model) {
        userService.delete(ID);
        return "redirect:admin";
    }
    // --------------------------------------------------------------------------
    // --------------------------------------------------------------------------


    //          PRODUCT
    @RequestMapping(value = "/manageProduct")
    public String manageProductPage(Model model) {
        List<Product> product = productService.findAll();
        model.addAttribute("products", product);
        return "manageProduct";
    }
    // FUNCTION CRUD
    @RequestMapping(value = "/addProduct")
    public String addProduct(Model model) {
        model.addAttribute("products", new Product());
        return "createProduct";
    }

    @RequestMapping(value = "saveProduct", method = RequestMethod.POST)
    public String saveProduct(Product product) {
        productService.save(product);
        return "redirect:manageProduct";
    }

    @RequestMapping(value = "/updateProduct", method = RequestMethod.GET)
    public String updateProduct(@RequestParam("id") Long ID, Model model) {
        Optional<Product> productUpdate = productService.findByID(ID);
        productUpdate.ifPresent(user -> model.addAttribute("updateProducts", productUpdate));
        return "updateProduct";
    }

    @RequestMapping(value = "/deleteProduct", method = RequestMethod.GET)
    public String deleteProduct(@RequestParam("id") Long ID, Model model) {
        productService.delete(ID);
        return "redirect:manageProduct";
    }
}