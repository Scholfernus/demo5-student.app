package com.example.demo5.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class StudentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "git_hub")
    private String gitHub;
    @Column(name = "start")
    @Size(min = 3)
    private String start;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="studentModel")
    private Set<TaskModel> tasks = new HashSet<>();
}
