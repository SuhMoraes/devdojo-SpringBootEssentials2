package com.suhmoraes.springboot2essentials.mapper;

import com.suhmoraes.springboot2essentials.domain.Anime;
import com.suhmoraes.springboot2essentials.resquests.AnimePostRequestBody;
import com.suhmoraes.springboot2essentials.resquests.AnimePutRequestBody;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-10-27T07:45:30-0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.10 (Azul Systems, Inc.)"
)
@Component
public class AnimeMapperImpl extends AnimeMapper {

    @Override
    public Anime toAnime(AnimePostRequestBody animePostRequestBody) {
        if ( animePostRequestBody == null ) {
            return null;
        }

        Anime anime = new Anime();

        anime.setName( animePostRequestBody.getName() );

        return anime;
    }

    @Override
    public Anime toAnime(AnimePutRequestBody animePutRequestBody) {
        if ( animePutRequestBody == null ) {
            return null;
        }

        Anime anime = new Anime();

        anime.setId( animePutRequestBody.getId() );
        anime.setName( animePutRequestBody.getName() );

        return anime;
    }
}
