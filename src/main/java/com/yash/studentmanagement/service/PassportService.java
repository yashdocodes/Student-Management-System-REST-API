package com.yash.studentmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yash.studentmanagement.entity.Passport;
import com.yash.studentmanagement.exception.ResourceNotFoundException;
import com.yash.studentmanagement.repository.PassportRepository;

@Service
public class PassportService {

    private final PassportRepository passportRepository;

    public PassportService(PassportRepository passportRepository) {
        this.passportRepository = passportRepository;
    }

    public Passport savePassport(Passport passport) {
        return passportRepository.save(passport);
    }

    public List<Passport> getAllPassports() {
        return passportRepository.findAll();
    }

    public Passport getPassportById(Long id) {
        return passportRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Passport not found with id : " + id));
    }
}