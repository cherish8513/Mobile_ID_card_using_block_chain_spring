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

    @GetMapping("/api/idCard/load/block/{application_id}")
    public BlockResponseRequestDto load_block(@PathVariable String application_id){
        BlockResponseRequestDto requestDto = new BlockResponseRequestDto();
        System.out.println(application_id);
        return idCardService.load_userId(requestDto, application_id);
    }

    @GetMapping("/api/idCard/load/photo/{privateKey}")
    public PhotoResponseRequestDto load_photo(@PathVariable String privateKey){
        PhotoResponseRequestDto requestDto = new PhotoResponseRequestDto();
        return  idCardService.load_photo(requestDto, privateKey);
    }
}
