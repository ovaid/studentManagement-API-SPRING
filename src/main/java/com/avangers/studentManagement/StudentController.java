package com.avangers.studentManagement;


import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.DeleteExchange;

import java.util.HashMap;
import java.util.Map;

import static javax.swing.UIManager.get;

@RestController
public class StudentController {

  @Autowired
  StudentService studentServiceRes;

   //getting the information
    @GetMapping("/get_student")
    public ResponseEntity getStudent(@RequestParam("admnNo") int admnNo){
        Student student = studentServiceRes.getStudent(admnNo);
        return new ResponseEntity<>(student, HttpStatus.FOUND);
    }

   //adding the information
    @PostMapping("/add_student")
    public ResponseEntity addStudent(@RequestBody Student student){
        String response = studentServiceRes.addStudent(student);
        return new ResponseEntity<>(response ,HttpStatus.CREATED);

    }

    //deleting student
    @DeleteMapping("/delete_student")
    public ResponseEntity deleteStudent(@RequestParam("q") int id){
        String response = studentServiceRes.deleteStudent(id);
        if(response.equals("Invalid id")) {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response,HttpStatus.FOUND);
    }

    //updating the information
    @PutMapping("/update_student")
    public ResponseEntity updateStudent(@RequestParam("id") int id , @RequestParam("age") int age){
        String response = studentServiceRes.updateStudent(id,age);
        if(response==null){
            return new ResponseEntity("invalid id" , HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity("valid" , HttpStatus.ACCEPTED);
    }
}
