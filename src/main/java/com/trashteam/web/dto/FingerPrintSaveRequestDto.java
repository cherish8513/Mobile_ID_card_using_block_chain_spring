package com.trashteam.web.dto;

import com.trashteam.domain.fingerPrint.FingerPrint;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//클라이언트에서 데이터베이스로 보내는 JSON
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
