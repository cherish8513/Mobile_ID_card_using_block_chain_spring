package com.trashteam.web.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FacePhotoSaveResponseDto {
    private String privateKey;
    private long count;

    @Builder
    public FacePhotoSaveResponseDto(String privateKey, long count){
        this.count = count;
        this.privateKey = privateKey;
    }

}
