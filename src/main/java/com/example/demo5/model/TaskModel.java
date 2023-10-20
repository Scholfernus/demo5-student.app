package com.example.demo5.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "deadline")
    private Date deadline;
    @Column(name = "description")
    private String description;
    @Column(name = "color")
    private String color;
    @Column(name = "creation_date")
    @DateTimeFormat(pattern = "yyy-MM-dd")
    private Date creationDate;
    @ManyToOne
    private StudentModel studentModel;
}
