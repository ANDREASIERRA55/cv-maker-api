package com.curriculum.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Data
@CrossOrigin("*")
@Table( name = "education")

public class Education {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    private long id;

    @Column
    private String title;
    @Column
    private String institution;


}
