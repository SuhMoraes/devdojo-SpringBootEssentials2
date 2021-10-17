package com.suhmoraes.springboot2essentials.domain;

import java.util.Objects;

public class Anime {

    private Long id;

    private String name;

    public Anime(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Anime(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Anime anime = (Anime) o;
        return Objects.equals(id, anime.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
