package com.example.userlogindatabaseweb.controller;

import com.example.userlogindatabaseweb.repository.TestRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller                         // notifies Spring this is our controller
public class TestController {


    TestRepository repository;
    public TestController(TestRepository repo){
        this.repository = repo;
    }



    @GetMapping("/start")
    public String start(Model model){
        model.addAttribute("user", repository.retrieveUserById(1));

        return "start";
    }


}
