package com.nest.nestemployeeapp_backend.dao;

import com.nest.nestemployeeapp_backend.model.EmployeeModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeDao extends CrudRepository<EmployeeModel,Integer> {

    @Query(value = "SELECT * FROM `employees` WHERE `username` = :username AND `password`= :password",nativeQuery = true)
    List<EmployeeModel> empLogin(String username,String password);

    @Query(value = "SELECT * FROM `employees` WHERE `id` = :empId",nativeQuery = true)
    List<EmployeeModel> viewProfile(String empId);
}