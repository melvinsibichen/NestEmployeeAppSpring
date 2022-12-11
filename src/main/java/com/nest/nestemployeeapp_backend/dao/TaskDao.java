package com.nest.nestemployeeapp_backend.dao;

import com.nest.nestemployeeapp_backend.model.EmployeeModel;
import com.nest.nestemployeeapp_backend.model.TaskModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface TaskDao extends CrudRepository<TaskModel,Integer> {

    @Query(value = "SELECT e.name,e.designation,e.email,e.mobile_no,t.task,t.status FROM `employees` AS e JOIN `tasks`as t ON e.id = t.employee_id ",nativeQuery = true)
    List<Map<String,String>> viewAllTasks();

    @Query(value = "SELECT * FROM `tasks` WHERE `employee_id`= :empId",nativeQuery = true)
    List<TaskModel> viewEmpTask(Integer empId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE `tasks` SET `status`=:status WHERE `id` = :id",nativeQuery = true)
    void updateStatus(String status,Integer id);
}