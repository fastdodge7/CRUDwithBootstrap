package com.example.myPage.CRUDwithBootstrap.Controller;

import com.example.myPage.CRUDwithBootstrap.Dto.MemberFormDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    @GetMapping(value = {"/", "/index.html"})
    public String index(Model model){
        return "index";
    }


}
