package com.trashteam.web.dto;

import com.trashteam.domain.fingerPrint.FingerPrint;
import lombok.Builder;

// 데이터베이스에서 클라이언트로 보내는 JSON
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
