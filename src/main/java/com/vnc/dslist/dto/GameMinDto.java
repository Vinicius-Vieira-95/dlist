package com.vnc.dslist.dto;

import java.io.Serializable;

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
    private String year;
    private String imgUrl;
    private String shortDescription;
}
 