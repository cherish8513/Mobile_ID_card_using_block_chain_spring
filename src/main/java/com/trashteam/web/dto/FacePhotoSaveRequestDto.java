package com.trashteam.web.dto;

import com.trashteam.domain.photo.FacePhoto;
import lombok.Builder;
import lombok.Data;

@Data
public class FacePhotoSaveRequestDto {
    private String privateKey;
    private String imgUrl;
    private String imgName;

    @Builder
    public FacePhotoSaveRequestDto(String imgName, String imgUrl, String privateKey){
        this.imgName = imgName;
        this.imgUrl = imgUrl;
        this.privateKey = privateKey;
    }

    public FacePhoto toEntity(){
        return FacePhoto.builder()
                .imgName(imgName)
                .imgUrl(imgUrl)
                .privateKey(privateKey)
                .build();
    }
}
