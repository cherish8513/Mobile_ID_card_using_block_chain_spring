package com.trashteam.web.dto;


import com.trashteam.domain.photo.FacePhoto;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//클라이언트에서 데이터베이스로 보내는 JSON
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
