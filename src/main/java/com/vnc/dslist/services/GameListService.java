package com.vnc.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vnc.dslist.dto.GameListDto;
import com.vnc.dslist.repositories.GameListRepository;

@Service
public class GameListService {
    
    @Autowired
    private GameListRepository gameListRepository;

    @Transactional
    public List<GameListDto> getGameList() {
        var list = gameListRepository.findAllGameListDtos();
        return list;
    }
}
