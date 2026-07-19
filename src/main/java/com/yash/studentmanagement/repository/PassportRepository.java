package com.yash.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.studentmanagement.entity.Passport;

public interface PassportRepository extends JpaRepository<Passport, Long> {

}
