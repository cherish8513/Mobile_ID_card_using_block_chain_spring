package com.trashteam.web.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDataDto {
    private String textData;
    private String privateKey;

    @Builder
    public UserDataDto(String textData, String privateKey) {
        this.textData = textData;
        this.privateKey = privateKey;
    }
}
