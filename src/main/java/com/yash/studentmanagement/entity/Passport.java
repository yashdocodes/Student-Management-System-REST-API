package com.yash.studentmanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "passports")
public class Passport 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "passport_number",
        nullable = false,
        unique = true,
        length = 20)
    private String passportNumber;

    public Passport() 
    {
    }

    public Passport(Long id, String passportNumber) 
    {
        this.id = id;
        this.passportNumber = passportNumber;
    }

    public Long getId() 
    {
        return id;
    }

    public String getPassportNumber() 
    {
        return passportNumber;
    }

    public void setId(Long id) 
    {
        this.id = id;
    }

    public void setPassportNumber(String passportNumber) 
    {
        this.passportNumber = passportNumber;
    }

    @OneToOne(mappedBy = "passport")
    @JsonIgnore
    private Student student;
    public Student getStudent() 
    {
    return student;
    }

    public void setStudent(Student student) 
    {
    this.student = student;
    }
}