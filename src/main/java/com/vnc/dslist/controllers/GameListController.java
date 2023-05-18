package com.vnc.dslist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vnc.dslist.dto.GameListDto;
import com.vnc.dslist.dto.GameMinDto;
import com.vnc.dslist.services.GameListService;
import com.vnc.dslist.services.GameService;
import com.vnc.dslist.services.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping("/game-list")
public class GameListController {
    
    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public Page<GameListDto> getAllGameList(Pageable pageable){
        var list = gameListService.getGameList(pageable);
        return list;
    }

    @GetMapping("/{listId}/games")
    public Page<GameMinDto> findByList(@PathVariable Long listId, Pageable pageable) throws ResourceNotFoundException {
        var list = gameService.findByList(listId, pageable);
        return list;
    }
}
