package com.curriculum.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Data
@CrossOrigin("*")
@Table( name = "job")

public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column
    private String year;
    @Column
    private String company;
    @Column
    private String description;


}

