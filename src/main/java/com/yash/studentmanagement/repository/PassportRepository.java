package com.yash.studentmanagement.repository;

import com.yash.studentmanagement.entity.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportRepository extends JpaRepository<Passport, Long> 
{

}