package com.curriculum.controllers;

import com.curriculum.entity.Education;
import com.curriculum.services.EducationService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/education")

public class EducationController {
    @Autowired
    private EducationService educationService;

    @PostMapping
    public Education saveEducation(@RequestBody Education education) {
        educationService.saveEducation(education);
        return education;
    }
    @GetMapping("/{id}")
    public Optional<Education> getEducationById(@PathVariable Long id) {

        return educationService.getEducationById(id);
    }
    @GetMapping
    public List<Education> allEducation(Education education) {

        return educationService.getAllEducation();
    }
    @PutMapping("/{id}")
    public String updateEducationById(
            @PathVariable long id, @RequestBody Education education) {
        education.setId(id);
        return (educationService.updateEducationById(education));
    }

    @DeleteMapping("/{id}")
    public void deleteEducationById(@PathVariable Long id) {

        educationService.deleteEducationById(id);
    }
}
