package com.suhmoraes.springboot2essentials.repository;

import com.suhmoraes.springboot2essentials.domain.Anime;

import java.util.List;

public interface AnimeRepository {
    List<Anime> listAll();

}
