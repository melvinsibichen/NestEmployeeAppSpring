package com.nest.nestemployeeapp_backend.controller;

import com.nest.nestemployeeapp_backend.dao.TaskDao;
import com.nest.nestemployeeapp_backend.model.EmployeeModel;
import com.nest.nestemployeeapp_backend.model.TaskModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TaskController {

    @Autowired
    private TaskDao taskDao;

    @CrossOrigin("*")
    @PostMapping(path = "/addTask", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> addTask(@RequestBody TaskModel task){
        taskDao.save(task);
        HashMap<String, String> map = new HashMap<>();
        map.put("status","success");
        return map;
    }

    @CrossOrigin("*")
    @GetMapping("/viewAllTask")
    public List<Map<String,String>> viewAllTask(){
        return (List<Map<String, String>>) taskDao.viewAllTasks();
    }

    @CrossOrigin("*")
    @PostMapping(path = "/viewEmpTask", consumes = "application/json", produces = "application/json")
    public List<TaskModel> viewEmpTask(@RequestBody TaskModel task){
        return (List<TaskModel>) taskDao.viewEmpTask(task.getEmployeeId());
    }

    @CrossOrigin("*")
    @PostMapping(path = "/updateStatus", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> updateStatus(@RequestBody TaskModel task){
        taskDao.updateStatus(task.getStatus(),task.getId());
        HashMap<String, String> map = new HashMap<>();
        map.put("status","success");
        return map;
    }
}