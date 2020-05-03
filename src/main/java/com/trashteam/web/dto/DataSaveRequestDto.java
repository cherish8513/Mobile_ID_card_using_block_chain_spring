package com.trashteam.web.dto;


import com.trashteam.domain.photo.FacePhoto;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DataSaveRequestDto{
    private String privateKey;
    private String imgUrl;
    private String imgName;
    private String textData;

    @Builder
    public DataSaveRequestDto(String imgName, String imgUrl, String textData){
        this.imgName = imgName;
        this.imgUrl = imgUrl;
        this.textData = textData;
    }

    public FacePhoto toEntity(){
        return FacePhoto.builder()
                .imgName(imgName)
                .imgUrl(imgUrl)
                .privateKey(privateKey)
                .build();
    }
}
