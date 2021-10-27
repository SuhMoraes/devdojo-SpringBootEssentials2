package com.suhmoraes.springboot2essentials.service;

import com.suhmoraes.springboot2essentials.domain.Anime;
import com.suhmoraes.springboot2essentials.exception.BadRequestException;
import com.suhmoraes.springboot2essentials.mapper.AnimeMapper;
import com.suhmoraes.springboot2essentials.repository.AnimeRepository;
import com.suhmoraes.springboot2essentials.resquests.AnimePostRequestBody;
import com.suhmoraes.springboot2essentials.resquests.AnimePutRequestBody;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AnimeService {

    private final AnimeRepository animeRepository;

    @Autowired
    public AnimeService(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    public List<Anime> listAll() {
        return animeRepository.findAll();
    }

    public List<Anime> findByName(String name) {
        return animeRepository.findByName(name);
    }

    public Anime findByIdOrThrowBadRequestException(Long id){
        return animeRepository.findById(id)
               .orElseThrow(() -> new BadRequestException("Anime not found!"));
    }

    @Transactional
    public Anime save(AnimePostRequestBody animePostRequestBody) {
       return animeRepository.save(AnimeMapper.INSTANCE.toAnime(animePostRequestBody));
    }

    public void delete(Long id){
        animeRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(AnimePutRequestBody animePutRequestBody){
         Anime savedAnime = findByIdOrThrowBadRequestException(animePutRequestBody.getId());
         Anime anime = AnimeMapper.INSTANCE.toAnime(animePutRequestBody);
         anime.setId(savedAnime.getId());
       animeRepository.save(anime);
    }


}
