package com.example.Seppocupranking;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Seppocupranking.domain.Joukkue;
import com.example.Seppocupranking.domain.JoukkueRepository;
import com.example.Seppocupranking.domain.Valmentaja;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JoukkueRepositoryTest {

	@Autowired
    private JoukkueRepository repository;

    @Test
    public void findByNimiShouldReturnJoukkue() {
        List<Joukkue> joukkueet = repository.findByNimi("Edmonton");
        assertThat(joukkueet).hasSize(1);
        assertThat(joukkueet.get(0).getNimi()).isEqualTo("Edmonton");
    }
    @Test
    public void createNewJoukkue() {
    	Joukkue joukkue = new Joukkue("Colorado", 1, 2, 3, 4, 5, 6, 7, new Valmentaja("Kanerva"));
    	repository.save(joukkue);
    	assertThat(joukkue.getId()).isNotNull();
    }
    @Test
    public void deleteJoukkue() {
    List<Joukkue> joukkueet = repository.deleteById(6);
    assertThat(joukkueet).isNull();
    }
}
