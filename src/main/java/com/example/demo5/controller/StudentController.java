package com.example.demo5.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
    @GetMapping("/students")
    public String getStudentList(){
        return "persons/personList";
    }
    @GetMapping("/addStudent")
    public String getAddStudent(){
        return "persons/addNewPerson";
    }
    @GetMapping("/editStudent")
    public String getEditStudent(){
        return "persons/editPerson";
    }
}
