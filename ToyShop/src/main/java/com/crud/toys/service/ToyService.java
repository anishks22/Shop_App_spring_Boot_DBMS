package com.crud.toys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crud.toys.dao.ToyRepository;
import com.crud.toys.entities.Toy;

@Component
public class ToyService {
	@Autowired
	private ToyRepository toyRepository;

	//get all toys
	public List<Toy> getAllToys() {
		List<Toy> list=(List<Toy>)this.toyRepository.findAll();
		return list;
	}

	//get single toy by id
	public Toy getToyById(int id) {
		Toy toy=null;
		try {
			toy=this.toyRepository.findById(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return toy;
	}

	public Toy addToy(Toy toy) {
		Toy result=toyRepository.save(toy);
		return result;
	}

	public void deleteToy(int toyId) {
		toyRepository.deleteById(toyId);
		
	}

	public void updateToy(Toy toy, int toyId) {
		toy.setId(toyId);
		toyRepository.save(toy);
		
	}
	
	
}
