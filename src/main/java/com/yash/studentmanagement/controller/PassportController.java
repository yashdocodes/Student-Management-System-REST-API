package com.yash.studentmanagement.controller;

import com.yash.studentmanagement.entity.Passport;
import com.yash.studentmanagement.service.PassportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passports")
public class PassportController {

    private final PassportService passportService;

    public PassportController(PassportService passportService) 
    {
        this.passportService = passportService;
    }

    @PostMapping
    public Passport createPassport(@RequestBody Passport passport) 
    {
        return passportService.savePassport(passport);
    }

    @GetMapping
    public List<Passport> getAllPassports() 
    {
        return passportService.getAllPassports();
    }

    @GetMapping("/{id}")
    public Passport getPassportById(@PathVariable Long id) 
    {
        return passportService.getPassportById(id);
    }
}