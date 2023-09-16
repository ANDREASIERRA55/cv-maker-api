package com.curriculum.services;

import com.curriculum.entity.Detail;
import com.curriculum.entity.Education;
import com.curriculum.repository.DetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;


@Service
public class DetailsService {
    @Autowired
    DetailRepository detailRepository;

    public Detail saveDetail(Detail newDetail) {
            Detail detail = new Detail();
            detail.setAddress(newDetail.getAddress());
            detail.setName(newDetail.getName());
            detail.setPhone(newDetail.getPhone());
            detail.setLinks(newDetail.getLinks());
            detail.setEmail(newDetail.getEmail());
            detail.setPhoto(newDetail.getPhoto());

            return detailRepository.save(detail);
    }
    public Optional<Detail> getDetailById(Long Id) {

        return  detailRepository.findById(Id);
    }
    public ArrayList<Detail> getAllDetails() {

        return (ArrayList<Detail>) detailRepository.findAll();
    }

    public String updateDetailById(Detail updateDetailById) {
        try {
            if (detailRepository.existsById(updateDetailById.getId())) {
                detailRepository.save (updateDetailById);

            } else {
                return ("Detail not updated: Record with ID :" + updateDetailById.getId() + "does not exist");
            }
        } catch (Exception error) {
            throw new RuntimeException("Detail not updated: " + error.getMessage());
        }
        return null;
    }





    public String deleteDetailById(long id) {
        try {
            detailRepository.deleteById(id) ;
            return ("delete" + id);
        } catch (Exception error) {
            return error.getMessage();
        }
    }

}