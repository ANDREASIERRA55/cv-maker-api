package com.curriculum.controllers;

import com.curriculum.entity.Detail;
import com.curriculum.services.DetailsService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/details")
public class DetailsController {

@Autowired
    private DetailsService detailsService;

    @PostMapping
    public Detail saveDetail(@RequestBody Detail detail) {
         detailsService.saveDetail(detail);
         return detail;
    }
    @GetMapping("/{id}")
    public Optional<Detail> getDetailById(@PathVariable Long id) {

        return detailsService.getDetailById(id);
    }
    @GetMapping
    public List<Detail> allDetails(Detail detail) {

        return detailsService.getAllDetails();
    }
    @PutMapping("/{id}")
    public String updateDetailById(@PathVariable long id, @RequestBody Detail detail) {
        detail.setId(id);
        return (detailsService.updateDetailById(detail));
    }
    @DeleteMapping("/{id}")
    public void deleteDetailById(@PathVariable Long id) {

        detailsService.deleteDetailById(id);
    }

}







