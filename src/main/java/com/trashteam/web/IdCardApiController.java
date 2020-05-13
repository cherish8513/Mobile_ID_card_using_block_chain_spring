package com.trashteam.web;

import com.trashteam.service.idCard.IdCardService;
import com.trashteam.web.dto.*;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class IdCardApiController {
   private final IdCardService idCardService;

    @PostMapping("/api/idCard/save/photo")
    public Long save(@RequestBody DataSaveRequestDto requestDto) {
        idCardService.save_userId(requestDto);
        return idCardService.save_photo(requestDto);
    }
}
