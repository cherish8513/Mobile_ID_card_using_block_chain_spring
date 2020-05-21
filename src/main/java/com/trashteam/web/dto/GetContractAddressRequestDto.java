package com.trashteam.web.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.GeneratedValue;

@Data
public class GetContractAddressRequestDto {
    private String application_id;

    @Builder
    public GetContractAddressRequestDto(String application_id){
        this.application_id = application_id;
    }
}
