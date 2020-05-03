package com.trashteam.web.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TextDataDto {
    private String textData;

    @Builder
    public TextDataDto(String textData){
        this.textData = textData;
    }
}
