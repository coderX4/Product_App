package com.ProductApp.controller;

import com.ProductApp.service.DeleteService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class DeleteControlller {
    @Autowired
    private DeleteService deleteService;

    @RequestMapping(value = "/deletehandler",method = RequestMethod.POST)
    public RedirectView delete(@RequestParam("id") int id, HttpServletRequest request) {
        this.deleteService.deleteServ(id);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath()+"/");
        return redirectView;
    }

}
