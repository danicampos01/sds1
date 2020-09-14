package com.ploma.dspesquisa.repositories.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ploma.dspesquisa.dto.GameDTO;
import com.ploma.dspesquisa.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameResource {


	@Autowired
	private GameService service;

	@GetMapping
	public ResponseEntity<List<GameDTO>> findall() {
		List<GameDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
