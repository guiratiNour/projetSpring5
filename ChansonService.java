package com.nour.demo.services;

import java.util.List;

import com.nour.demo.dto.ChansonDTO;
import com.nour.demo.entities.Chanson;

public interface ChansonService {
	ChansonDTO saveChanson(ChansonDTO p);
	ChansonDTO updateChanson(ChansonDTO p);
	void deleteChanson(Chanson p);
	 void deleteChansonById(Long id);
	 ChansonDTO getChanson(Long id);
	 Chanson getChansonById(Long id);
	List<ChansonDTO> getAllChansons();
	List<Chanson> findByAlbumIdAlbum(Long id);
	ChansonDTO convertEntityToDto (Chanson chanson);
	Chanson convertDtoToEntity(ChansonDTO chansonDto);
	List<Chanson> findByNomContains(String nom);



}
