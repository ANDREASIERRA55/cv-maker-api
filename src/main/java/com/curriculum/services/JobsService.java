package com.curriculum.services;

import com.curriculum.entity.Job;
import com.curriculum.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service

public class JobsService {
    @Autowired
    JobRepository jobRepository;
    public Job saveJob(Job newJob) {
        Job job = new Job();
        job.setYear(newJob.getYear());
        job.setCompany(newJob.getCompany());
        job.setDescription(newJob.getDescription());
        return jobRepository.save(job);
    }
    public Optional<Job> getJobsById(Long Id) {

        return  jobRepository.findById(Id);
    }
    public ArrayList<Job> getAllJobs() {

        return (ArrayList<Job>) jobRepository.findAll();
    }
    public String updateJobById(Job updateJobById) {
        try {
            if (jobRepository.existsById(updateJobById.getId())) {
                jobRepository.save(updateJobById);
            } else {
                return ("Job not updated: Record with ID :" + updateJobById.getId() + "does not exist");
            }
        } catch (Exception error) {
            throw new RuntimeException("Job not updated: " + error.getMessage());
            //when the exception can be prevented//
        }
        return null;
    }

    public String deleteJobById(long id) {
        try {
            jobRepository.deleteById(id);
            return "Deleted " + id;
        } catch (Exception error) {
            return error.getMessage();
        }
    }

}
