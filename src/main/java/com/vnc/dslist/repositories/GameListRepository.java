package com.vnc.dslist.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vnc.dslist.dto.GameListDto;
import com.vnc.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {

    @Query("SELECT new com.vnc.dslist.dto.GameListDto(obj.id, obj.name) FROM GameList obj")
    public Page<GameListDto> findAllGameListDtos(Pageable pageable);
}
