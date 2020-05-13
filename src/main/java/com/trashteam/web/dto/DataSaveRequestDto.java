package com.trashteam.web.dto;


import com.trashteam.domain.photo.FacePhoto;
import com.trashteam.domain.user.UserHash;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DataSaveRequestDto {
    private String privateKey;
    private String imgUrl;
    private String imgName;
    private String contract_address;
    private String application_id;

    @Builder
    public DataSaveRequestDto(String imgName, String imgUrl, String privateKey, String contract_address, String application_id){
        this.imgName = imgName;
        this.imgUrl = imgUrl;
        this.privateKey = privateKey;
        this.contract_address = contract_address;
        this.application_id = application_id;
    }
}
