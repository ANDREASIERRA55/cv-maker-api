package com.curriculum.services;

import com.curriculum.entity.Detail;
import com.curriculum.entity.Education;
import com.curriculum.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EducationService {
    @Autowired
    EducationRepository educationRepository;

    public Education saveEducation(Education newEducation) {
        Education education = new Education();
        education.setTitle(newEducation.getTitle());
        education.setInstitution(newEducation.getInstitution());
        return educationRepository.save(education);
    }
    public Optional<Education> getEducationById(Long Id) {

        return  educationRepository.findById(Id);
    }
    public ArrayList<Education> getAllEducation() {

        return (ArrayList<Education>) educationRepository.findAll();
    }
    public String updateEducationById(Education updateEducationById) {
        try {
            if (educationRepository.existsById(updateEducationById.getId())) {
                educationRepository.save(updateEducationById);
                return ("Education updated: " + updateEducationById.getId());
            } else {
                return ("Education not updated: Record with ID :" + updateEducationById.getId() + "does not exist");
            }
        } catch (Exception error) {
            throw new RuntimeException("Education not updated: " + error.getMessage());
        }

    }
    public String deleteEducationById(Long id) {
        try {
            educationRepository.deleteById(id);
            return "Delete" + id;
        } catch (Exception error) {
            return error.getMessage();
        }

    }

}

