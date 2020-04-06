package com.trashteam.web.dto;

import com.trashteam.domain.fingerPrint.FingerPrint;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FingerPrintSaveRequestDto {

    private String privateKey;
    private String imgUrl;
    private String imgName;

    @Builder
    public FingerPrintSaveRequestDto(String imgName, String imgUrl){
        this.imgName = imgName;
        this.imgUrl = imgUrl;
    }

    public FingerPrint toEntity(){
        return FingerPrint.builder()
                .imgName(imgName)
                .imgUrl(imgUrl)
                .privateKey(privateKey)
                .build();
    }
}
