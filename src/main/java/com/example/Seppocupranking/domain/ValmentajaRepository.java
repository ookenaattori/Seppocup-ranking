package com.example.Seppocupranking.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;



public interface ValmentajaRepository extends CrudRepository<Valmentaja, Long> {
	
	List<Valmentaja> findByNimi(String nimi);
	
}