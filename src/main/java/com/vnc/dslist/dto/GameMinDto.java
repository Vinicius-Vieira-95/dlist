package com.vnc.dslist.dto;

import java.io.Serializable;

import com.vnc.dslist.interfaces.GameMinProjection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GameMinDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;

    public GameMinDto(GameMinProjection projection) {
        id = projection.getId();
        title = projection.getTitle();
        year = projection.getYear();
        imgUrl = projection.getImgUrl();
        shortDescription = projection.getShortDescription();
    }
}
