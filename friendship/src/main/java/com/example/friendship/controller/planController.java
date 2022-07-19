package com.example.friendship.controller;

import com.example.friendship.PlansService;
import com.example.friendship.dto.RegisPlansDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
public class planController {

    @Autowired
    private PlansService plansService;

    @PostMapping("/add")
    public void regPlans(@Valid @RequestBody RegisPlansDto regisPlansDto)throws Exception {

        plansService.regPlansService(regisPlansDto);
    }
}
