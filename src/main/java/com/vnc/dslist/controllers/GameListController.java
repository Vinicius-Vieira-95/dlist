package com.vnc.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vnc.dslist.dto.GameListDto;
import com.vnc.dslist.services.GameListService;

@RestController
@RequestMapping("/game-list")
public class GameListController {
    
    @Autowired
    private GameListService service;

    @GetMapping("/lists")
    public List<GameListDto> getAllGameList(){
        var list = service.getGameList();
        return list;
    }
}
