package com.ploma.dspesquisa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ploma.dspesquisa.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

	
}
