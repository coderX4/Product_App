package com.ProductApp.controller;

import com.ProductApp.model.Product;
import com.ProductApp.service.ReadService;
import com.ProductApp.service.UpdateService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UpdateController {
    private int uid;
    @Autowired
    private ReadService readService;
    @Autowired
    private UpdateService updateService;

    @RequestMapping(value = "/updatehandler",method = RequestMethod.POST)
    public String updatehandler(@RequestParam("id") int id,Model model){
        this.uid = id;
        Product product = this.readService.readServ(this.uid);
        model.addAttribute("product", product);
        return "ProductUpdate";
    }

    @RequestMapping(value = "/afterupdate",method = RequestMethod.POST)
    public RedirectView afterUpdate(@ModelAttribute Product product, HttpServletRequest request) {

        this.updateService.updateServ(this.uid,product);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath()+"/");
        return redirectView;
    }

}
