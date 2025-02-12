package com.fanap.hotel.controller;

import com.fanap.hotel.util.constants.Routes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = Routes.ADMIN_ROUTE)
public class AdminController {

    @PostMapping(Routes.BLOCK)
    public void blockCustomer(){
    }
}
