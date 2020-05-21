package com.trashteam.web.dto;

import com.trashteam.domain.user.UserHash;
import lombok.Builder;
import lombok.Data;

@Data
public class UserHashSaveRequestDto {
    private String contract_address;
    private String application_id;

    @Builder
    public UserHashSaveRequestDto(String contract_address, String application_id){
        this.contract_address = contract_address;
        this.application_id = application_id;
    }

    public UserHash toEntity(){
        return UserHash.builder()
                .application_id(application_id)
                .contract_address(contract_address)
                .build();
    }
}
