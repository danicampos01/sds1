package com.ploma.dspesquisa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ploma.dspesquisa.entities.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {

	
}
