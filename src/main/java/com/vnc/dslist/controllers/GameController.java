package com.vnc.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vnc.dslist.dto.GameMinDto;
import com.vnc.dslist.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {
    
    @Autowired
    private GameService service;

    @GetMapping("/list")
    public List<GameMinDto> findAll() {
        var list = service.findAll();
        return list;
    }
}
