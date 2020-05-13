package com.trashteam.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class UserHash {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = false)
    private String contract_address;

    @Column(length = 255, nullable = false)
    private String application_id;

    @Builder
    public UserHash(String contract_address, String application_id){
        this.contract_address = contract_address;
        this.application_id = application_id;
    }
}