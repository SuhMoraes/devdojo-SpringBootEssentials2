package com.suhmoraes.springboot2essentials.util;

import com.suhmoraes.springboot2essentials.domain.Anime;

public class AnimeCreator {

    public static Anime creteAnimeToBeSaved() { // ANime que não tem Id
        return Anime.builder()
                .name("Naruto")
                .build();

    }

    public static Anime creteValidAnime() { // Anime com Id válido
        return Anime.builder()
                .name("Naruto")
                .build();

    }

    public static Anime creteValidUpdateAnime() {
        return Anime.builder()
                .name("Naruto 2")
                .build();

    }
}
