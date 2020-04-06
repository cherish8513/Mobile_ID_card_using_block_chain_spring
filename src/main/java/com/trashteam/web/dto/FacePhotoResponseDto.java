package com.trashteam.web.dto;

import com.trashteam.domain.photo.FacePhoto;
import lombok.Builder;
public class FacePhotoResponseDto {

    private String privateKey;
    private String facePhotoUrl;

    @Builder
    public FacePhotoResponseDto(FacePhoto entity){
        this.privateKey = entity.getPrivateKey();
        this.facePhotoUrl = entity.getImgUrl();
    }

    @Builder
    public FacePhotoResponseDto(String privateKey, String facePhotoUrl){
        this.privateKey = privateKey;
        this.facePhotoUrl = facePhotoUrl;
    }
}
