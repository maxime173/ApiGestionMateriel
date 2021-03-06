package com.materiel.gestion.apigestion.model.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data @Entity
@Table (name = "interface")
public class Interface {
	
	public Interface() { }
	public Interface(Long id) { setId(id); }
	public Interface(Long id, Materiel m) { setId(id); setMateriel(m); }
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="id", length=11, nullable=false)
	private Long id;
	
	@Column(name="nom", length=10, nullable=false)
	private String nom;
	
	@Column(name="mac", length=14, nullable=false)
	private String mac;
	
	@ManyToOne
	@JoinColumn(name = "idtype", nullable = false)
	private TypeInterface typeif;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "idmateriel", nullable = false)
	private Materiel materiel;
	
    @OneToOne(mappedBy = "interf")
    private AdresseIp adresse;


}
