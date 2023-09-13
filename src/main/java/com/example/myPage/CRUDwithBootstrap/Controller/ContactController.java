package com.example.myPage.CRUDwithBootstrap.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {
    @GetMapping("/contact.html")
    public String blog(Model model){
        return "contact";
    }
}
