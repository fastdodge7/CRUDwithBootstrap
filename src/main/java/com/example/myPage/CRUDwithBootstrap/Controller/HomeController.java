package com.example.myPage.CRUDwithBootstrap.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = {"/", "/index.html"})
    public String index(Model model){
        return "index";
    }
}
