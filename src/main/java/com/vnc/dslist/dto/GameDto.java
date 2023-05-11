package com.vnc.dslist.dto;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

import com.vnc.dslist.entities.Game;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String title;
    private String year;
    private String genre;
    private String platforms;
    private Double score;
    private String imgUrl;
    private String shortDescription;
    private String longDescription;

    public GameDto(Game entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
