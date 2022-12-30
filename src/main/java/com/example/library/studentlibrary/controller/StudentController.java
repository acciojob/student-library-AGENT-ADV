package com.example.library.studentlibrary.controller;

import com.example.library.studentlibrary.models.Student;
import com.example.library.studentlibrary.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Add required annotations
@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    //Add required annotations
    @GetMapping("/student/studentByEmail")
    public ResponseEntity<Student> getStudentByEmail(@RequestParam("email") String email){

        return new ResponseEntity<>(studentService.getDetailsByEmail(email), HttpStatus.OK);
        //"Student details printed successfully "
    }

    //Add required annotations
    @GetMapping("/student/studentById")
    public ResponseEntity<Student> getStudentById(@RequestParam("id") int id){

        return new ResponseEntity<>(studentService.getDetailsById(id), HttpStatus.OK);
    }

    //Add required annotations
    @PostMapping("/student")
    public ResponseEntity<String> createStudent(@RequestBody Student student){

        studentService.createStudent(student);

        return new ResponseEntity<>("the student is successfully added to the system", HttpStatus.CREATED);
    }

    //Add required annotations
    @PutMapping("/student")
    public ResponseEntity<String> updateStudent(@RequestBody Student student){

        studentService.updateStudent(student);
        return new ResponseEntity<>("student is updated", HttpStatus.ACCEPTED);
    }

    //Add required annotations
    @DeleteMapping("/student")
    public ResponseEntity<String> deleteStudent(@RequestParam("id") int id){

        studentService.deleteStudent(id);
        return new ResponseEntity<>("student is deleted", HttpStatus.ACCEPTED);
    }

}