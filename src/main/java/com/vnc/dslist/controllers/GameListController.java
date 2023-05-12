package com.vnc.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vnc.dslist.dto.GameListDto;
import com.vnc.dslist.dto.GameMinDto;
import com.vnc.dslist.services.GameListService;
import com.vnc.dslist.services.GameService;

@RestController
@RequestMapping("/game-list")
public class GameListController {
    
    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDto> getAllGameList(){
        var list = gameListService.getGameList();
        return list;
    }

    @GetMapping("/{listId}/games")
    public List<GameMinDto> findByList(@PathVariable Long listId) {
        var list = gameService.findByList(listId);
        return list;
    }
}
