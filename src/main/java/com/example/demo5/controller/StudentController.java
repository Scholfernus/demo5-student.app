package com.example.demo5.controller;

import com.example.demo5.model.StudentModel;
import com.example.demo5.service.StudentService;
import jakarta.ws.rs.Path;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/students")
    public String getStudentList(Model model) {
        List<StudentModel> studentList = studentService.getStudentsList();
        model.addAttribute("studentModel", studentList);
        return "persons/personList";
    }

    @GetMapping("/addStudent")
    public String getAddStudent() {
        return "persons/addNewPerson";
    }

    @GetMapping("/editStudent/{id}")
    public String getEditStudent(@PathVariable("id") Long id, Model model) {//
        StudentModel student = studentService.getStudentById(id);
        model.addAttribute("studentModel", student);
        return "persons/editPerson";
    }

    @PostMapping("/addStudent")
    public RedirectView postAddStudent(StudentModel student) {
        studentService.saveStudent(student);
        return new RedirectView("/students");
    }

    @PostMapping("/editStudent/{id}")
    public RedirectView postEditStudent(@PathVariable("id") Long id, StudentModel student) {
        studentService.saveEditStudent(student, id);
        return new RedirectView("/students");
    }

    @PostMapping("/del/{id}")
    public RedirectView delStudentById(@PathVariable("id") Long id, StudentModel student) {
        studentService.deleteStudent(id);
        return new RedirectView("/students");
    }
}
