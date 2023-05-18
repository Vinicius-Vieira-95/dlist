package com.vnc.dslist.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vnc.dslist.dto.GameListDto;
import com.vnc.dslist.repositories.GameListRepository;

@Service
public class GameListService {
    
    @Autowired
    private GameListRepository gameListRepository;

    @Transactional
    public Page<GameListDto> getGameList(Pageable pageable) {
        var list = gameListRepository.findAllGameListDtos(pageable);
        return list;
    }
}
