package com.example.Seppocupranking;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Seppocupranking.domain.Kayttaja;
import com.example.Seppocupranking.domain.KayttajaRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class KayttajaRepositoryTest {

	
	@Autowired
    private KayttajaRepository repository;

    @Test
    public void findByUsernameShouldReturnUser() {
    	Kayttaja user = repository.findByUsername("admin");
        assertThat(user.getUsername()).isEqualTo("admin");
    }
    @Test
    public void createNewUser() {
    	Kayttaja user = new Kayttaja("userTest", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
    	repository.save(user);
    	assertThat(user.getId()).isNotNull();
    }
    
    @Test
    public void deleteUser() {
    Kayttaja user = repository.deleteById(1);
    assertThat(user).isNull();
    }
}
