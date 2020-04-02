package com.trashteam.web.dto;

import com.trashteam.domain.photo.FacePhoto;
import lombok.Builder;
//데이터베이스에서 클라이언트로 보내는 JSON
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
