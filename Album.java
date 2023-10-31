package com.nour.demo.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Album {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idalbum;
	private String nomChanseur;
	private String nom;
	@JsonIgnore

	@OneToMany(mappedBy = "album")
	private List<Chanson> chansons;
	


}
