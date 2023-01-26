package com.avangers.studentManagement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepositoryResponse;

    public Student getStudent(int id){
        return studentRepositoryResponse.getStudent(id);
    }

    public String addStudent(Student student){
        return studentRepositoryResponse.addStudent(student);
    }

    public String updateStudent(int id,int age){
        return studentRepositoryResponse.updateStudent(id,age);
    }


    public String deleteStudent(int id){
        return studentRepositoryResponse.deleteStudent(id);
    }
}
