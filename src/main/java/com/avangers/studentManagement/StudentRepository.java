package com.avangers.studentManagement;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository {

   Map<Integer, Student> db = new HashMap<>();

   public Student getStudent(int id){
       return db.get(id);
   }

   public String addStudent(Student student){
       int id = student.getAdmnNo();
       db.put(id,student);
       return "student added successfully";
   }

   public String deleteStudent(int id){
       if(!db.containsKey(id)){
           return "student not found";
       }

       db.remove(id);
       return "student deleted successfully";
   }


   public String updateStudent(int id, int age){
       if(!db.containsKey(id)) {
           return "student not found !! you entered wrong ID";
       }
       db.get(id).setAge(24);
       return "student details updated !!";
   }

}
