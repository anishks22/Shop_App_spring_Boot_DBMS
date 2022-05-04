package com.crud.toys.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.toys.entities.Toy;
import com.crud.toys.service.ToyService;

@RestController
public class ToyController {
	
	@Autowired
	private ToyService toyService;
	
	// Get All Toys
	@GetMapping("/toys")
	public ResponseEntity<List<Toy>> getToys(){
		List<Toy> list=toyService.getAllToys();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	
	//Get single toy
	@GetMapping("/toys/{id}")
	public ResponseEntity<Toy> getToy(@PathVariable("id") int id){
		Toy toy=toyService.getToyById(id);
		if(toy==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(toy));
	}
	
	
	// create new Toy
	@PostMapping("/toys")
	public ResponseEntity<Toy> addToy(@RequestBody Toy toy){
		Toy t=null;
		try {
			t=this.toyService.addToy(toy);
			System.out.println(toy);
			return ResponseEntity.of(Optional.of(toy));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	//Delete Toy 
	@DeleteMapping("/toys/{toyId}")
	public ResponseEntity<Void> deleteToy(@PathVariable("toyId") int toyId){
		try {
			this.toyService.deleteToy(toyId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	//Update Toy
	
	@PutMapping("/toys/{toyId}")
	public ResponseEntity<Toy> updateToy(@RequestBody Toy toy,@PathVariable("toyId") int toyId){
		try {
			this.toyService.updateToy(toy,toyId);
			return ResponseEntity.ok().body(toy);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	
	
}
