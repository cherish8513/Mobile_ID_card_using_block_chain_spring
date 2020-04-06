package com.trashteam.web.dto;


import com.trashteam.domain.photo.FacePhoto;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FacePhotoSaveRequestDto {
    private String privateKey;
    private String imgUrl;
    private String imgName;

    @Builder
    public FacePhotoSaveRequestDto(String imgName, String imgUrl){
        this.imgName = imgName;
        this.imgUrl = imgUrl;
    }

    public FacePhoto toEntity(){
        return FacePhoto.builder()
                .imgName(imgName)
                .imgUrl(imgUrl)
                .privateKey(privateKey)
                .build();
    }
}
