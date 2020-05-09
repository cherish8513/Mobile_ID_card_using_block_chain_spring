package com.trashteam.domain.text;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class TextData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = false)
    private String privateKey;

    @Column(length = 500, nullable = false)
    private String textData;

    @Builder
    public TextData(String privateKey, String textData){
        this.privateKey = privateKey;
        this.textData = textData;
    }
}