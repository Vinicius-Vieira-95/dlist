package com.vnc.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vnc.dslist.dto.GameDto;
import com.vnc.dslist.dto.GameMinDto;
import com.vnc.dslist.repositories.GameRepository;

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
        var game = gameRepository.findById(id).orElseThrow(() ->  new  Exception("game não encontado"));
        return new GameDto(game);
    }
}
