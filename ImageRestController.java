package com.nour.demo.restcontrollers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nour.demo.dto.ChansonDTO;
import com.nour.demo.entities.Image;
import com.nour.demo.entities.Chanson;
import com.nour.demo.services.ImageService;
import com.nour.demo.services.ChansonService;

@RestController
@RequestMapping("/api/image")
@CrossOrigin(origins = "*")

public class ImageRestController {
	@Autowired
	 ImageService imageService ;
	@Autowired
	 ChansonService chansonService;
	 
	 
	 @RequestMapping(value = "/upload" , method = RequestMethod.POST)
	 public Image uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
	 return imageService.uplaodImage(file);
	 }
	 @RequestMapping(value = "/get/info/{id}" , method = RequestMethod.GET)
	 public Image getImageDetails(@PathVariable("id") Long id) throws IOException {
	 return imageService.getImageDetails(id) ;
	 }
	 @RequestMapping(value = "/load/{id}" , method = RequestMethod.GET)
	 public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException 
	{
	 return imageService.getImage(id);
	 }
	 
	 
	 @RequestMapping(value = "/delete/{id}" , method = RequestMethod.DELETE)
	 public void deleteImage(@PathVariable("id") Long id){
	 imageService.deleteImage(id);
	 }
	 @RequestMapping(value="/update",method = RequestMethod.PUT)
	 public Image UpdateImage(@RequestParam("image")MultipartFile file) throws IOException {
	 return imageService.uplaodImage(file);
	 }
	 @PostMapping(value = "/uplaodImageouv/{idouv}" )
	 public Image uploadMultiImages(@RequestParam("image")MultipartFile file,
	 @PathVariable("idouv") Long idouv) 
	throws IOException {
	 return imageService.uplaodImageProd(file,idouv);
	 }
	@RequestMapping(value = "/getImagesouv/{idouv}" , 
	 method = RequestMethod.GET)
	 public List<Image> getImagesProd(@PathVariable("idouv") Long idouv) 
	throws IOException {
	 return imageService.getImagesParProd(idouv);
	 }
	@RequestMapping(value = "/uploadFS/{id}" , method = RequestMethod.POST)
	 public void uploadImageFS(@RequestParam("image") MultipartFile 
	file,@PathVariable("id") Long id) throws IOException {
	 ChansonDTO p = chansonService.getChanson(id);
	 p.setImagePath(id+".jpg");
	 
	Files.write(Paths.get(System.getProperty("user.home")+"/images/"+p.getImagePath())
	, file.getBytes());
	chansonService.saveChanson(p);
	 }
	@RequestMapping(value = "/loadfromFS/{id}" , 
			 method = RequestMethod.GET,
			 produces = org.springframework.http.MediaType.IMAGE_JPEG_VALUE)
			 public byte[] getImageFS(@PathVariable("id") Long id) throws IOException {
			 
			ChansonDTO p = chansonService.getChanson(id);
			 return
			Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/images/"+p.getImagePath()));}}
			 
