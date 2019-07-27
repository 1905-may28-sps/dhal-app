package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.DhalPlaylists;
import com.revature.service.PlaylistsService;

@RestController
@CrossOrigin("*")
public class PlaylistsController {

	@Autowired
	private PlaylistsService service;

	@RequestMapping(value = "/playlists", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DhalPlaylists> add(@RequestBody DhalPlaylists playlist) {
		System.out.println(playlist);
		DhalPlaylists u = service.add(playlist);
		if (u == null)
			return new ResponseEntity<DhalPlaylists>(HttpStatus.CONFLICT);
		return new ResponseEntity<DhalPlaylists>(u, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/playlists", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DhalPlaylists>> findAll() {
		List<DhalPlaylists> dhalPlaylists = service.getAll();
		if(dhalPlaylists == null || dhalPlaylists.size() == 0) return new ResponseEntity<List<DhalPlaylists>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<DhalPlaylists>>(dhalPlaylists, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/playlists/playlistId={id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DhalPlaylists> findByPlaylistId(@PathVariable int id) {
		DhalPlaylists u = service.findByPlaylistId(id);
		if(u == null ) return new ResponseEntity<DhalPlaylists>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<DhalPlaylists>(u, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/playlists/ownerId={id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DhalPlaylists> findByOwnerId(@PathVariable int id) {
		DhalPlaylists u = service.findByOwnerId(id);
		if(u == null ) return new ResponseEntity<DhalPlaylists>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<DhalPlaylists>(u, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/playlists/name={name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DhalPlaylists> findByName(@PathVariable String name) {
		DhalPlaylists u = service.findByName(name);
		if(u == null ) return new ResponseEntity<DhalPlaylists>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<DhalPlaylists>(u, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/ownerPlaylists/ownerId={id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DhalPlaylists>> findListByOwnerId(@PathVariable int id) {
		List<DhalPlaylists> u =  service.findListByOwnerId(id);
		if(u == null || u.size() == 0 ) return new ResponseEntity<List<DhalPlaylists>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<DhalPlaylists>>(u, HttpStatus.OK);
	}


}