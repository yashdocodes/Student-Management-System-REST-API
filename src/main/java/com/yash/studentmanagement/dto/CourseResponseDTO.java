package com.yash.studentmanagement.dto;

public class CourseResponseDTO 
{

    private Long id;
    private String courseName;
    private int duration;

    public CourseResponseDTO() 
    {
    }

    public CourseResponseDTO(Long id, String courseName, int duration) 
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
}