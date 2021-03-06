package com.materiel.gestion.apigestion.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.materiel.gestion.apigestion.model.entite.AdresseIp;
import com.materiel.gestion.apigestion.model.entite.Interface;
import com.materiel.gestion.apigestion.service.IAdresseIpService;
import com.materiel.gestion.apigestion.service.IInterfaceService;

@RestController
@RequestMapping(path = "api/v1/interfaces", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class InterfaceRestController {

	@Autowired
	IInterfaceService service;
	
	@Autowired
	IAdresseIpService adresseIpService;
	
	@GetMapping("/{id}")
	public Interface getById(@PathVariable Long id) {
		return service.getById(id);
	}
	
	@GetMapping
	public List<Interface> getAll() {
		return service.getAll();
	}
	
	@PostMapping("/{id}/adresseips")
	public ResponseEntity<AdresseIp> createAdresseIp(@RequestBody AdresseIp adresseIp, @PathVariable Long id) throws URISyntaxException {
		adresseIp.setInterf(new Interface(id));
		AdresseIp a = adresseIpService.create(adresseIp);
		return ResponseEntity.created(new URI("api/v1/adresseips/" + a.getId())).body(a);
	}
	
	@GetMapping("/{id}/adresseips")
	public AdresseIp getAdresseIp(@PathVariable Long id) {
		return adresseIpService.getById(id);
	}
	
	@PutMapping("/{id}/adresseips")
    public AdresseIp edit(@RequestBody AdresseIp adr, @PathVariable Long id) {
        adr.setInterf(new Interface(id));
        return adresseIpService.edit(adr);
    }

	@DeleteMapping("/{id}/adresseips")
    public void deleteAdresseIp(@PathVariable Long id){
		Interface interf = new Interface(id);
		AdresseIp adr = new AdresseIp();
		adr.setInterf(interf);
        adresseIpService.delete(adr);
    }
}


