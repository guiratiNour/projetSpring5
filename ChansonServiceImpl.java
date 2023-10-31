package com.nour.demo.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nour.demo.dto.ChansonDTO;
import com.nour.demo.entities.Chanson;
import com.nour.demo.repos.ImageRepository;
import com.nour.demo.repos.ChansonRepository;

@Service
public class ChansonServiceImpl implements ChansonService{
@Autowired
ChansonRepository chansonRepository;
@Autowired
ModelMapper modelMapper;
@Autowired
ImageRepository imageRepository;

	@Override
	public ChansonDTO saveChanson(ChansonDTO p) {
		
		return convertEntityToDto(chansonRepository.save(convertDtoToEntity(p)));
	}

	/*@Override
	public OuvrierDTO updateOuvrier(OuvrierDTO p) {
		
		return convertEntityToDto(ouvrierRepository.save(convertDtoToEntity(p)));
	}*/
	@Override
	public ChansonDTO updateChanson(ChansonDTO o) {
	//Long oldProdImageId = 
	//this.getOuvrier(o.getIdOuvrier()).getImage().getIdImage();
	//Long newProdImageId = o.getImage().getIdImage();
	ChansonDTO prodUpdated = convertEntityToDto(chansonRepository.save(convertDtoToEntity(o)));
	//if (oldProdImageId != newProdImageId) //si l'image a été modifiée
	//imageRepository.deleteById(oldProdImageId);
	return prodUpdated;
	}

	@Override
	public void deleteChanson(Chanson p) {
		chansonRepository.delete(p);
		
	}

	@Override
	public void deleteChansonById(Long id) {
		ChansonDTO o = getChanson(id);
		 //suuprimer l'image avant de supprimer le produit
		/*try {
		Files.delete(Paths.get(System.getProperty("user.home")+"/images/"+o.getImagePath()));
		} catch (IOException e) {
		e.printStackTrace();
		} */
		chansonRepository.deleteById(id);
		
	}

	@Override
	public ChansonDTO getChanson(Long id) {
		
		return convertEntityToDto(chansonRepository.findById(id).get());
	}

	@Override
	public List<ChansonDTO> getAllChansons() {
	
		return chansonRepository.findAll().stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<Chanson> findByAlbumIdAlbum(Long id) {
		
		return chansonRepository.findByAlbumIdAlbum(id);
	}
	
	@Override
	public ChansonDTO convertEntityToDto(Chanson chanson) {
		ChansonDTO chansonDTO = modelMapper.map(chanson, ChansonDTO.class);
		 return chansonDTO; 
	 /*OuvrierDTO ouvrierDTO = new OuvrierDTO();
	 ouvrierDTO.setIdProduit(produit.getIdProduit());
	 ouvrierDTO.setNomProduit(produit.getNomProduit());
	 ouvrierDTO.setPrixProduit(produit.getPrixProduit());
	 ouvrierDTO.setDateCreation(p.getDateCreation());
	 ouvrierDTO.setCategorie(produit.getCategorie()); 
	 return produitDTO; */
	 
	/* return OuvrierDTO.builder()
	.idOuvrier(ouvrier.getIdOuvrier())
	.nom(ouvrier.getNom())
	.salaire(ouvrier.getSalaire())
	.tel(ouvrier.getTel())
	.dateEmbauche(ouvrier.getDateEmbauche())
	.chantier(ouvrier.getChantier())
	.build();*/
	}
	@Override
	public Chanson convertDtoToEntity(ChansonDTO chansonDto) {
		Chanson chanson = new Chanson();
		chanson = modelMapper.map(chansonDto, Chanson.class);

	/*Ouvrier ouvrier = new Ouvrier();
	ouvrier.setIdOuvrier(ouvrierDto.getIdOuvrier());
	ouvrier.setNom(ouvrierDto.getNom());
	ouvrier.setTel(ouvrierDto.getTel());
	ouvrier.setSalaire(ouvrierDto.getSalaire());
	ouvrier.setDateEmbauche(ouvrierDto.getDateEmbauche());
	ouvrier.setChantier(ouvrierDto.getChantier()); */
	 return chanson; 
	}

	@Override
	public Chanson getChansonById(Long id) {
		
		return chansonRepository.findById(id).get();
	}

	@Override
	public List<Chanson> findByNomContains(String nom) {
		
		return chansonRepository.findByNomContains(nom);
	}

	

}
