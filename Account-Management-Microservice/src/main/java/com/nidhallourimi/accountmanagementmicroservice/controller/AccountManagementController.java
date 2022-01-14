package com.nidhallourimi.accountmanagementmicroservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "account")
public class AccountManagementController {
    @GetMapping(path = "/status/check")
    public String getStatus(){
        return "account Management working...";
    }

}
