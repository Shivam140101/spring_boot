package com.thyme.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.Date;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
public class MyController {

    @RequestMapping(value = "/about", method = GET)
    public String about(Model model){

        System.out.println("Inside about handler");

        // Putting Data in Model
        model.addAttribute("name", "Shivam Ahlawat");
        model.addAttribute("currentDate", new Date().toString());


        return "about";
        // show about.html
    }


}
