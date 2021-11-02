package com.suhmoraes.springboot2essentials.repository;

import com.suhmoraes.springboot2essentials.domain.Anime;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;


@DataJpaTest
@DisplayName("Tests for Anime Repository")

class AnimeRepositoryTest {

    @Autowired
    private AnimeRepository animeRepository;

    @Test
    @DisplayName("Save persists anime when Succeful")
    void save_PersistAnime_WhenSuccessful(){
        Anime animeToBeSaved = creteAnime(); // Cria o anime
        Anime animeSaved = this.animeRepository.save(animeToBeSaved); // Salva o Anime
        Assertions.assertThat(animeSaved).isNotNull(); // Verifica se o Anime não é nulo
        Assertions.assertThat(animeSaved.getId()).isNotNull(); // Verifica se o Anime Tem ID
        Assertions.assertThat(animeSaved.getName()).isEqualTo(animeToBeSaved.getName());// Verifica se o name que foi salvo é igual ao name criado.
    }

    @Test
    @DisplayName("Save update anime when Succeful")
    void save_UpdateAnime_WhenSuccessful(){
        Anime animeToBeSaved = creteAnime();
        Anime animeSaved = this.animeRepository.save(animeToBeSaved);
        animeSaved.setName("Overlord"); // Altera o nome do Anime
        Anime animeUpdated = this.animeRepository.save(animeSaved); // Salva a alteração do nome
        Assertions.assertThat(animeUpdated).isNotNull(); // Verifica que o Anime não é nulo
        Assertions.assertThat(animeUpdated.getId()).isNotNull(); // Verifica se o Anime Tem ID
        Assertions.assertThat(animeUpdated.getName()).isEqualTo(animeSaved.getName()); // Verifica se o name alterado é o mesmo que o name criado.
    }

    @Test
    @DisplayName("Delete removes anime when Succeful")
    void save_DeleteAnime_WhenSuccessful(){
        Anime animeToBeSaved = creteAnime();
        Anime animeSaved = this.animeRepository.save(animeToBeSaved);
        this.animeRepository.delete(animeSaved);
        Optional<Anime> animeOptional = this.animeRepository.findById(animeSaved.getId());
        Assertions.assertThat(animeOptional.isEmpty());

    }

    @Test
    @DisplayName("Find By Name returns list of anime when Succeful")
    void findByName_ReturnListOfAnime_WhenSuccessful(){
        Anime animeToBeSaved = creteAnime();
        Anime animeSaved = this.animeRepository.save(animeToBeSaved);
        String name = animeSaved.getName();
        List<Anime> animes = this.animeRepository.findByName(name);
        Assertions.assertThat(animes).isNotEmpty();
        Assertions.assertThat(animes).contains(animeSaved);
    }

    @Test
    @DisplayName("Find By Name returns empty list when no anime is found")
    void findByName_ReturnListOfAnime_WhenAnimeIsNotFound(){
        List<Anime> animes = this.animeRepository.findByName("Man");
        Assertions.assertThat(animes).isEmpty();
    }

    private Anime creteAnime() {
        return Anime.builder()
                .name("Naruto")
                .build();

    }
}