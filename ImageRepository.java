package com.nour.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nour.demo.entities.Image;

public interface ImageRepository extends JpaRepository<Image , Long>{

}
