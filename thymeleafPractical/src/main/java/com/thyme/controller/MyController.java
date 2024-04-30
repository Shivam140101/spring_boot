package com.thyme.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.Date;
import java.util.List;

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


    // handling iteration
    @GetMapping("/example-loop")
    public String iterateHandler(Model model){


        List<String> names = List.of("Ankit", "Laxmi", "Karan", "John");
        model.addAttribute("names", names);
        return "iterate";
    }

    // Handler for Conditional Statements
    @GetMapping("/condition")
    public String conditionHandler(Model model){

        System.out.println("ConditionHandler Executed");

        model.addAttribute("isActive",false);
        model.addAttribute("gender","M");

        List<Integer> list = List.of(233/*, 45, 65, 55, 5678*/);
        model.addAttribute("myList",list);
        return "condition";
    }


    // Handler for including fragments
    @GetMapping("/service")
    public String serviceHandler(Model model){

        return "service";
    }


}
