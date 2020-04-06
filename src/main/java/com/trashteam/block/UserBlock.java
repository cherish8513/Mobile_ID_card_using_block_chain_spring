package com.trashteam.block;

import lombok.Builder;
import lombok.Getter;
@Getter
public class UserBlock {
    private String fingerPrintPrivateKey;
    private String facePhotoPrivateKey;
    private String name;
    private String addressInfo;
    private String residentNumber;
    private String publishDate;
    private String publisher;

    @Builder
    public UserBlock(String fingerPrintPrivateKey, String facePhotoPrivateKey,
                     String name, String addressInfo, String residentNumber,
                     String publisher, String publishDate){
        this.facePhotoPrivateKey = facePhotoPrivateKey;
        this.fingerPrintPrivateKey = fingerPrintPrivateKey;
        this.name = name;
        this.addressInfo = addressInfo;
        this.residentNumber = residentNumber;
        this.publishDate =publishDate;
        this.publisher = publisher;

    }

}
