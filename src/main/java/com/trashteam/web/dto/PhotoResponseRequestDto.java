package com.trashteam.web.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PhotoResponseRequestDto {
    private String imgUrl;
    private String imgName;
}