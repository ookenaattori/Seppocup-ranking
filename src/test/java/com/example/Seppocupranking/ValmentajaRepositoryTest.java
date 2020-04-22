package com.example.Seppocupranking;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Seppocupranking.domain.Valmentaja;
import com.example.Seppocupranking.domain.ValmentajaRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ValmentajaRepositoryTest {
	
	 @Autowired
	    private ValmentajaRepository repository;

	    @Test
	    public void findByNameShouldReturnBook() {
	        List<Valmentaja> valmentajat = repository.findByNimi("Nivalainen");
	        assertThat(valmentajat).hasSize(1);
	        assertThat(valmentajat.get(0).getNimi()).isEqualTo("Nivalainen");
	    }
	    @Test
	    public void createNewValmentaja() {
	    	Valmentaja valmentaja = new Valmentaja("Kanerva");
	    	repository.save(valmentaja);
	    	assertThat(valmentaja.getValmentajaid()).isNotNull();
	    }
	    @Test
	    public void deleteValmentaja() {
	    List<Valmentaja> valmentajat = repository.deleteById(1);
	    assertThat(valmentajat).isNull();
	    }

}
