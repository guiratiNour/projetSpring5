package com.nour.demo.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nour.demo.dto.ChansonDTO;
import com.nour.demo.entities.Chanson;
import com.nour.demo.services.ChansonService;
import com.nour.demo.repos.ChansonRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ChansonRestController {
@Autowired
ChansonService chansonService;
@Autowired
ChansonRepository chansonRepository;
@RequestMapping(path="all",method = RequestMethod.GET)
public List<ChansonDTO> getAllChansons() {
return chansonService.getAllChansons();
}
@RequestMapping(path="/addouv",method = RequestMethod.POST)
public ChansonDTO createChanson(@RequestBody ChansonDTO chanson) {
return chansonService.saveChanson(chanson);
}
@RequestMapping(path="/updateouv",method = RequestMethod.PUT)
public ChansonDTO updateChanson(@RequestBody ChansonDTO chanson) {
return chansonService.updateChanson(chanson);
}
@RequestMapping(value="/delouv/{id}",method = RequestMethod.DELETE)
public void deleteChanson(@PathVariable("id") Long id)
{
	chansonService.deleteChansonById(id);
}
@RequestMapping(value="/chAlbum/{idAlbum}", method = RequestMethod.GET)
public List<Chanson> getChansonsByCatId(@PathVariable("idAlbum") Long idAlbum) {
    return chansonService.findByAlbumIdAlbum(idAlbum);
}
@RequestMapping(value="/getbyid/{id}", method=RequestMethod.GET)
public Chanson getChansonById(@PathVariable("id") Long id) {
	return chansonService.getChansonById(id)	;
}
@RequestMapping(value="/ouvrsByName/{nom}",method = RequestMethod.GET)
public List<Chanson> findByNomContains(@PathVariable("nom") String nom) {
return chansonService.findByNomContains(nom);
}

}
