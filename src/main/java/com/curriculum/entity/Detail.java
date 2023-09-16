package com.curriculum.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Data
@CrossOrigin("*")
@Table( name = "details")

public class Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String photo;
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private String phone;
    @Column
    private String email;
    @Column
    private String links;

}
