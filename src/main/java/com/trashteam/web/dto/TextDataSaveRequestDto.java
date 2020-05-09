package com.trashteam.web.dto;

import com.trashteam.domain.text.TextData;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TextDataSaveRequestDto {
    private String textData;
    private String privateKey;

    @Builder
    public TextDataSaveRequestDto(String textData){
        this.textData = textData;
    }

    public TextData toEntity(){
        return TextData.builder()
                .textData(textData)
                .privateKey(privateKey)
                .build();
    }
}
