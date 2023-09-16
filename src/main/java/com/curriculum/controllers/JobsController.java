package com.curriculum.controllers;

import com.curriculum.entity.Job;
import com.curriculum.services.JobsService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/jobs")

public class JobsController {

    @Autowired
    private JobsService jobsService;

    @PostMapping
    public Job saveJob(@RequestBody Job job) {
        jobsService.saveJob(job);
        return job;
    }
    @GetMapping("/{id}")
    public Optional<Job> getJobById(@PathVariable Long id) {

        return jobsService.getJobsById(id);
    }
    @GetMapping
    public List<Job> allJobs(Job job) {

        return jobsService.getAllJobs();
    }

    @PutMapping("/{id}")
    public String updateJobById(@PathVariable long id, @RequestBody Job job) {
        job.setId(id);
        return (jobsService.updateJobById(job));
    }

    @DeleteMapping("/{id}")
    public void deleteJobById(@PathVariable Long id) {

        jobsService.deleteJobById(id);
    }
}
