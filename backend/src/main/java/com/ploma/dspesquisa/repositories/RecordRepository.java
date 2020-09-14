package com.ploma.dspesquisa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ploma.dspesquisa.entities.Game;
import com.ploma.dspesquisa.entities.Record;

public interface RecordRepository extends JpaRepository<Record, Long> {

	
}
