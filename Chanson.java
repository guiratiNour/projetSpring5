package com.nour.demo.entities;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Chanson {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idChanson;
	private String nom;
	private int duree;
	private Date dateCreation;
	@ManyToOne
	private Album album;
	/*@OneToOne
	private Image image;*/
	@OneToMany (mappedBy = "chanson")
	private List<Image> images;
	private String imagePath;



	
}
