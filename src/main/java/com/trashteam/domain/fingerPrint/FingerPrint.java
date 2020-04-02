package com.trashteam.domain.fingerPrint;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
//FingerPrint Database
@Getter
@NoArgsConstructor
@Entity
public class FingerPrint {

    @Id
    @Column(length = 255, nullable = false)
    private String privateKey;

    @Column(length = 255, nullable = false)
    private String imgUrl;

    @Column(length = 255, nullable = false)
    private String imgName;

    @Builder
    public FingerPrint(String privateKey, String imgUrl, String imgName){
        this.privateKey = privateKey;
        this.imgUrl = imgUrl;
        this.imgName = imgName;
    }
}