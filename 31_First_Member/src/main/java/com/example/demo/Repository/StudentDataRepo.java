package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.StudentInformation;

public interface StudentDataRepo extends JpaRepository<StudentInformation,Integer>{

}
