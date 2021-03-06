package com.materiel.gestion.apigestion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.materiel.gestion.apigestion.model.entite.TypeInterface;
import com.materiel.gestion.apigestion.service.ITypeInterfaceService;

@RestController
@RequestMapping(path = "api/v1/typesinterfaces", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TypeInterfaceRestController {

	@Autowired
	ITypeInterfaceService service;
	
	@GetMapping("/{id}")
	public TypeInterface getById(@PathVariable Long id) {
		return service.getById(id);
	}
	
	@GetMapping
	public List<TypeInterface> getAll() {
		return service.getAll();
	}
}
