package com.vnc.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<GameMinDto> findAll() {
        var list = gameRepository.findAllGameMinDto();
        return list;
    }

    @Transactional(readOnly = true)
    public GameDto getGameById(Long id) throws Exception {
        var game = gameRepository.findById(id).orElseThrow(() ->  new ResourceNotFoundException("Game not found", HttpStatus.NOT_FOUND));     
        return new GameDto(game);
    }

    @Transactional(readOnly = true)
    public List<GameMinDto> findByList(Long listId) throws ResourceNotFoundException {
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        if(list.isEmpty()) throw new ResourceNotFoundException("List not found", HttpStatus.NOT_FOUND);
        var listGameDto = list.stream().map(x -> new GameMinDto(x)).toList();
        return listGameDto;
    }
}
