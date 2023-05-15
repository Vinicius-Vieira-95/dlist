package com.vnc.dslist.dto;

import com.vnc.dslist.interfaces.GameMinProjection;

import lombok.Getter;


@Getter
public class GameMinDto {

    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;

    public GameMinDto(Long id, String title, String year, String imgUrl, String shortDescription) {
        this.id = id;
        this.title = title;
        this.year = Integer.parseInt(year);
        this.imgUrl = imgUrl;
        this.shortDescription = shortDescription;
    }
    
    public GameMinDto(GameMinProjection projection) {
        id = projection.getId();
        title = projection.getTitle();
        year = projection.getYear();
        imgUrl = projection.getImgUrl();
        shortDescription = projection.getShortDescription();
    }
}
