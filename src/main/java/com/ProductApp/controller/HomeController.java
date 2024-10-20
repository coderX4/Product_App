package com.ProductApp.controller;

import com.ProductApp.model.Product;
import com.ProductApp.service.ReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ReadService readService;

    @RequestMapping("/home")
    public String home(Model model) {
        List<Product> productList = readService.readServAll();
        model.addAttribute("productList", productList);
        return "Home";
    }

}
