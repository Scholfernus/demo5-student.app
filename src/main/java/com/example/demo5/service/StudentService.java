package com.example.demo5.service;

import com.example.demo5.model.StudentModel;
import com.example.demo5.model.TaskModel;
import com.example.demo5.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
@Slf4j
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void saveStudent(StudentModel student) {
    studentRepository.save(student);
    }
    public List<StudentModel> getStudentList(){
        return studentRepository.findAll();
    }

    public StudentModel getStudentById(Long id) {
       return studentRepository.findById(id).orElse(null);
    }

    public void saveEditStudent(StudentModel student, Long id) {
        student.setId(id);
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
//    public List<StudentModel>sortByName(){
//        List<StudentModel> sortList = studentRepository.findSortedNamesOrderByLastNameAsc();
//        Stream<StudentModel> sortedList = sortList.stream().sorted();
//        log.info("last_name {}", sortedList);
//        return sortedList.toList();
//    }
}
