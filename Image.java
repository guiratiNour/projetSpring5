package com.nour.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idImage;
	private String name;
	private String type;
	@Column(name = "IMAGE", length = 4048576)
	@Lob
	private byte[] image;
	@ManyToOne()
	@JoinColumn (name="Chanson_ID")
	@JsonIgnore
	private Chanson chanson;
}



