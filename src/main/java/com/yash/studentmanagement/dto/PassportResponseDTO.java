package com.yash.studentmanagement.dto;

public class PassportResponseDTO 
{

    private Long id;
    private String passportNumber;

    public PassportResponseDTO() 
    {
    }

    public PassportResponseDTO(Long id, String passportNumber) 
    {
        this.id = id;
        this.passportNumber = passportNumber;
    }

    public Long getId() 
    {
        return id;
    }

    public void setId(Long id) 
    {
        this.id = id;
    }

    public String getPassportNumber() 
    {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) 
    {
        this.passportNumber = passportNumber;
    }
}