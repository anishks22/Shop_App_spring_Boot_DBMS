package com.crud.toys.dao;

import org.springframework.data.repository.CrudRepository;

import com.crud.toys.entities.Toy;

public interface ToyRepository extends CrudRepository<Toy, Integer>{
	public Toy findById(int id);
}
