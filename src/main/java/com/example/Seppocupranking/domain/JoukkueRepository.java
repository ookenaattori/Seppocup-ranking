package com.example.Seppocupranking.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;



public interface JoukkueRepository extends CrudRepository<Joukkue, Long> {
	// findByOrderByPisteet funktiolla voidaan hakea joukkueet pistejärjestyksessä
	List<Joukkue> findByOrderByPisteetDesc();
	List<Joukkue> findByNimi(String nimi);
	List<Joukkue> deleteById(long id);
	
}