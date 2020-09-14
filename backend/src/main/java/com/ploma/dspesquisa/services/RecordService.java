package com.ploma.dspesquisa.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ploma.dspesquisa.dto.GameDTO;
import com.ploma.dspesquisa.dto.RecordDTO;
import com.ploma.dspesquisa.dto.RecordInsertDTO;
import com.ploma.dspesquisa.entities.Game;
import com.ploma.dspesquisa.entities.Record;
import com.ploma.dspesquisa.repositories.GameRepository;
import com.ploma.dspesquisa.repositories.RecordRepository;

@Service
public class RecordService {

	@Autowired
	private RecordRepository repository;
	
	@Autowired
	private GameRepository gameRepository;

	@Transactional
	public RecordDTO insert(RecordInsertDTO dto) {

		Record entity = new Record();
		entity.setName(dto.getName());
		entity.setAge(dto.getAge());
		entity.setMoment(Instant.now());
		
		Game game = gameRepository.getOne(dto.getGameId());
		entity.setGame(game);
		
		entity = repository.save(entity);
		return new RecordDTO(entity);
	}

}
