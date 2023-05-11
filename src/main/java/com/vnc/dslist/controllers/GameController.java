package com.vnc.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vnc.dslist.dto.GameDto;
import com.vnc.dslist.dto.GameMinDto;
import com.vnc.dslist.services.GameService;

import lombok.var;

@RestController
@RequestMapping(value = "/games")
public class GameController {
    
    @Autowired
    private GameService service;

    @GetMapping()
    public List<GameMinDto> findAll() {
        var list = service.findAll();
        return list;
    }

    // @GetMapping("/lists")
    // public List<GameListDto> gameListDto() {
    //     var list = service.getGameList();
    //     return list;
    // }

    @GetMapping("/{id}")
    public GameDto getId(@PathVariable("id") Long id) throws Exception{
        var gameDto = service.getGameById(id);
        return gameDto;
    }
}
