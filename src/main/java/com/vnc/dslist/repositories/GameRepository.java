package com.vnc.dslist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vnc.dslist.dto.GameMinDto;
import com.vnc.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

    @Query("SELECT new com.vnc.dslist.dto.GameMinDto(obj.id, obj.title, obj.year, obj.imgUrl, obj.shortDescription) FROM Game obj ORDER BY obj.title")
    public List<GameMinDto> findAllGameMinDto();
}
