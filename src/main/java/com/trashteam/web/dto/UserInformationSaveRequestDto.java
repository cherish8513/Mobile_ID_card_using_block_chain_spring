package com.trashteam.web.dto;

import com.trashteam.block.UserBlock;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserInformationSaveRequestDto {

    private String name;
    private String addressInfo;
    private String residentNumber;
    private String fingerPrintPrivateKey;
    private String facePhotoPrivateKey;
    private String publishDate;
    private String publisher;


    @Builder
    public UserInformationSaveRequestDto(String name, String addressInfo, String residentNumber,
                                         String publishDate, String publisher)
    {
        this.name=name;
        this.addressInfo = addressInfo;
        this.residentNumber=residentNumber;
        this.publishDate = publishDate;
        this.publisher = publisher;
    }

    public UserBlock userBlockObject(){
        return UserBlock.builder()
                .facePhotoPrivateKey(facePhotoPrivateKey)
                .fingerPrintPrivateKey(fingerPrintPrivateKey)
                .addressInfo(addressInfo)
                .name(name)
                .residentNumber(residentNumber)
                .publishDate(publishDate)
                .publisher(publisher)
                .build();
    }
}
