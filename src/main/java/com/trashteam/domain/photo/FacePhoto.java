package com.trashteam.domain.photo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
//facePhoto database
@Getter
@NoArgsConstructor
@Entity
public class FacePhoto {

    @Id
    @Column(length = 255, nullable = false)
    private String privateKey;

    @Column(length = 255, nullable = false)
    private String imgUrl;

    @Column(length = 255, nullable = false)
    private String imgName;

    @Builder
    public FacePhoto(String privateKey, String imgUrl, String imgName){
        this.privateKey = privateKey;
        this.imgUrl = imgUrl;
        this.imgName = imgName;
    }
}