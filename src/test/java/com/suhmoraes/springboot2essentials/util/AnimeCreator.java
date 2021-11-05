package com.suhmoraes.springboot2essentials.util;

import com.suhmoraes.springboot2essentials.domain.Anime;

public class AnimeCreator {

    public static Anime createAnimeToBeSaved() { // ANime que não tem Id
        return Anime.builder()
                .name("Nichijou")
                .build();

    }

    public static Anime createValidAnime() { // Anime com Id válido
        return Anime.builder()
                .name("Nichijou")
                .id(1L)
                .build();

    }

    public static Anime createValidUpdateAnime() {
        return Anime.builder()
                .name("Nichijou 2")
                .id(1l)
                .build();

    }
}
