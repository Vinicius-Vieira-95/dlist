package com.vnc.dslist.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vnc.dslist.dto.GameDto;
import com.vnc.dslist.dto.GameMinDto;
import com.vnc.dslist.interfaces.GameMinProjection;
import com.vnc.dslist.repositories.GameRepository;
import com.vnc.dslist.services.exceptions.ResourceNotFoundException;

@Service
public class GameService {
    
    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public Page<GameMinDto> findAll(Pageable page) {
        var list = gameRepository.findAllGameMinDto(page);
        return list;
    }

    @Transactional(readOnly = true)
    public GameDto getGameById(Long id) throws Exception {
        var game = gameRepository.findById(id).orElseThrow(() ->  new ResourceNotFoundException("Game not found", HttpStatus.NOT_FOUND));     
        return new GameDto(game);
    }

    @Transactional(readOnly = true)
    public Page<GameMinDto> findByList(Long listId, Pageable pageable) throws ResourceNotFoundException {
        Page<GameMinProjection> list = gameRepository.searchByList(listId, pageable);
        if(list.isEmpty()) throw new ResourceNotFoundException("List not found", HttpStatus.NOT_FOUND);
        var listGameDto = list.map(game -> new GameMinDto(game));
        return listGameDto;
    }
}
