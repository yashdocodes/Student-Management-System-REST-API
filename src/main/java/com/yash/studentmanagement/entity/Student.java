package com.yash.studentmanagement.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Student 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name; 

    @Min(value = 1, message = "Age must be at least 1")
    @Max(value = 120, message = "Age must not exceed 120")
    private int age;

    @OneToOne(
    cascade = CascadeType.ALL,
    fetch = FetchType.EAGER
    )
    @JoinColumn(name = "passport_id")
    private Passport passport;

    public Student() 
    {
    }

    public Student(int id, String name, int age, Passport passport) 
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.passport = passport;
    }

    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public int getAge() 
    {
        return age;
    }

    public void setAge(int age) 
    {
        this.age = age;
    }

    public Passport getPassport() 
    {
    return passport;
    }

    public void setPassport(Passport passport) 
    {
    this.passport = passport;
    }

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    public Department getDepartment() 
    {
    return department;
    }

    public void setDepartment(Department department) 
    {
    this.department = department;
    }
}