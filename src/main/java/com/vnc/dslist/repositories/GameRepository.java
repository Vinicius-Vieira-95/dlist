package com.vnc.dslist.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vnc.dslist.dto.GameMinDto;
import com.vnc.dslist.entities.Game;
import com.vnc.dslist.interfaces.GameMinProjection;

public interface GameRepository extends JpaRepository<Game, Long> {

    @Query("SELECT new com.vnc.dslist.dto.GameMinDto(obj.id, obj.title, obj.year, obj.imgUrl, obj.shortDescription) FROM Game obj ORDER BY obj.title")
    public Page<GameMinDto> findAllGameMinDto(Pageable pageable);

    @Query(nativeQuery = true, value = """
            SELECT tb_game.id, tb_game.title, tb_game.game_year AS `year`, tb_game.img_url AS imgUrl,
            tb_game.short_description AS shortDescription, tb_belonging.position
            FROM tb_game
            INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
            WHERE tb_belonging.list_id = :listId
            ORDER BY tb_belonging.position
            	""")
    Page<GameMinProjection> searchByList(Long listId, Pageable pageable);
}
