package com.ProductApp.controller;

import com.ProductApp.model.Product;
import com.ProductApp.service.AddService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AddController {
    @Autowired
    private AddService addService;

    @RequestMapping("/addProduct")
    public String addProduct() {
        return "ProductAdd";
    }
    @RequestMapping(value = "/addhandler",method = RequestMethod.POST)
    public RedirectView addhandler(@ModelAttribute Product product, HttpServletRequest request) {
        this.addService.addserv(product);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath()+"/");
        return redirectView;
    }
}
