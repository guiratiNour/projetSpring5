package com.nour.demo.dto;

import java.util.Date;
import java.util.List;

import com.nour.demo.entities.Album;
import com.nour.demo.entities.Image;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChansonDTO {
    private Long idChanson;
    private String nom;
    private int duree;
    private Date dateCreation;
    private Album album;

    private List<Image> images;
    private String imagePath;

    // Ajouter la méthode setImagePath(String)
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
