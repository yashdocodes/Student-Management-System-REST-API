package com.yash.studentmanagement.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Course 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;

    private int duration;

    @ManyToMany(mappedBy = "courses")
    @JsonIgnore
    private Set<Student> students = new HashSet<>();

    public Course() 
    {
    }

    public Course(Long id, String courseName, int duration) 
    {
        this.id = id;
        this.courseName = courseName;
        this.duration = duration;
    }

    public Long getId() 
    {
        return id;
    }

    public void setId(Long id) 
    {
        this.id = id;
    }

    public String getCourseName() 
    {
        return courseName;
    }

    public void setCourseName(String courseName) 
    {
        this.courseName = courseName;
    }

    public int getDuration() 
    {
        return duration;
    }

    public void setDuration(int duration) 
    {
        this.duration = duration;
    }

    public Set<Student> getStudents() 
    {
        return students;
    }

    public void setStudents(Set<Student> students) 
    {
        this.students = students;
    }
}