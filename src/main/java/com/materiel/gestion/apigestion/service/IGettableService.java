package com.materiel.gestion.apigestion.service;

import java.util.List;

public interface IGettableService<E> {
	public E getById(Long id);	
	public List<E> getAll();
}
