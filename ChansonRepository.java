package com.nour.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nour.demo.entities.Chanson;

public interface ChansonRepository extends JpaRepository<Chanson, Long>{
	List<Chanson> findByAlbumIdAlbum(Long id);
	List<Chanson> findByNomContains(String nom);
}
