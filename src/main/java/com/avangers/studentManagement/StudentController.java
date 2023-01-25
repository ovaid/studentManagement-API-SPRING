package com.avangers.studentManagement;


import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.DeleteExchange;

import java.util.HashMap;
import java.util.Map;

import static javax.swing.UIManager.get;

@RestController
public class StudentController {

   Map<Integer,Student> db = new HashMap<>();

   //getting the information
    @GetMapping("/get_student")
    public Student getStudent(@RequestParam("r") int admnNo){
        return db.get(admnNo);
    }

   //adding the information
    @PostMapping("/add_student")
    public String addStudent(@RequestBody Student student){
        int admnNo = student.getAdmnNo();
        db.put(admnNo,student);

        return "congrats you have been added to the list";
    }

    //deleting student
    @DeleteMapping("/delete_student")
    public String deleteStudent(@RequestParam("q") int admnNo){
        db.remove(admnNo);
        return "student is deleted successfully";
    }

    //updating the information
    @PutMapping("/update_student/{admnNo}")
    public String updateStudent(@PathVariable int admnNo, @RequestBody Student student) {
        student.setAge(student.getAge());
        student.setName(student.getName());
        student.setState(student.getState());
        db.put(admnNo,student);
        return "student updated successfully";
    }
}
