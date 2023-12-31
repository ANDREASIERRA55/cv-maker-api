package com.curriculum.repository;

import com.curriculum.entity.Detail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailRepository extends JpaRepository<Detail, Long> {

}
