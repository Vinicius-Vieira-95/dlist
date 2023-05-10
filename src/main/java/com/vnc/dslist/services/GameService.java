package com.vnc.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vnc.dslist.dto.GameMinDto;
import com.vnc.dslist.repositories.GameRepository;

@Service
public class GameService {
    
    @Autowired
    private GameRepository repository;

    public List<GameMinDto> findAll() {
        var list = repository.findAllGameMinDto();
        return list;
    }
}
