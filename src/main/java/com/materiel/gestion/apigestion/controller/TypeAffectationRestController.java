package com.materiel.gestion.apigestion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.materiel.gestion.apigestion.model.entite.TypeAffectation;
import com.materiel.gestion.apigestion.service.ITypeAffectationService;

@RestController
@RequestMapping(path = "api/v1/typeaffectations", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@CrossOrigin(origins = "*", allowedHeaders = "*")
//@Api(tags="Type Affectation Rest API")
public class TypeAffectationRestController {
	
	@Autowired
	ITypeAffectationService service;
	
	@GetMapping("/{id}")
	public TypeAffectation getById(@PathVariable Long id) {
		return service.getById(id);
	}
	
	@GetMapping
	public List<TypeAffectation> getAll() {
		return service.getAll();
	}
}
