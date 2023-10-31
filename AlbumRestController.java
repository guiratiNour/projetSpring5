package com.nour.demo.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nour.demo.entities.Album;
import com.nour.demo.repos.AlbumRepository;

@RestController
@RequestMapping("/api/ch")
@CrossOrigin
public class AlbumRestController {
@Autowired
AlbumRepository chantierRepository;
@RequestMapping(method=RequestMethod.GET)
public List<Album> getAllChantiers()
{
return chantierRepository.findAll();
}
@RequestMapping(value="/{id}",method = RequestMethod.GET)
public Album getChantierById(@PathVariable("id") Long id) {
return chantierRepository.findById(id).get();
}

}
