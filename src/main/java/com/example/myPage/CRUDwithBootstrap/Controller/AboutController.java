package com.example.myPage.CRUDwithBootstrap.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {

    @GetMapping("/about.html")
    public String about(Model model){
        return "blog";
    }
}
