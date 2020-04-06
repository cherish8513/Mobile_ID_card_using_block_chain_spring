package com.trashteam.web.dto;

import com.trashteam.domain.fingerPrint.FingerPrint;
import lombok.Builder;

public class FingerPrintResponseDto {
    private String privateKey;
    private String fingerPrintPhotoUrl;

    @Builder
    public FingerPrintResponseDto(FingerPrint entity){
        this.privateKey = entity.getPrivateKey();
        this.fingerPrintPhotoUrl = entity.getImgUrl();
    }

    @Builder
    public FingerPrintResponseDto(String privateKey, String fingerPrintPhotoUrl){
        this.privateKey = privateKey;
        this.fingerPrintPhotoUrl = fingerPrintPhotoUrl;
    }
}
