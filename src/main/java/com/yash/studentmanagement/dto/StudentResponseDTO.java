package com.yash.studentmanagement.dto;

import java.util.List;

public class StudentResponseDTO 
{

    private Integer id;
    private String name;
    private int age;

    private PassportResponseDTO passport;
    private DepartmentResponseDTO department;
    private List<CourseResponseDTO> courses;

    public StudentResponseDTO() 
    {
    }

    public StudentResponseDTO(Integer id, String name, int age, PassportResponseDTO passport, DepartmentResponseDTO department,
    List<CourseResponseDTO> courses) 
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.passport = passport;
        this.department = department;
        this.courses = courses;
    }

    public Integer getId() 
    {
        return id;
    }

    public void setId(Integer id) 
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

    public PassportResponseDTO getPassport() 
    {
        return passport;
    }

    public void setPassport(PassportResponseDTO passport) 
    {
        this.passport = passport;
    }

    public DepartmentResponseDTO getDepartment() 
    {
        return department;
    }

    public void setDepartment(DepartmentResponseDTO department) 
    {
        this.department = department;
    }

    public List<CourseResponseDTO> getCourses() 
    {
        return courses;
    }

    public void setCourses(List<CourseResponseDTO> courses) 
    {
        this.courses = courses;
    }
}