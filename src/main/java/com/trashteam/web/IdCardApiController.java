package com.trashteam.web;

import com.trashteam.block.UserBlock;
import com.trashteam.service.idCard.IdCardService;
import com.trashteam.web.dto.FacePhotoSaveRequestDto;
import com.trashteam.web.dto.FingerPrintSaveRequestDto;
import com.trashteam.web.dto.UserInformationSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//URL 매핑 컨트롤러
@RequiredArgsConstructor
@RestController
public class IdCardApiController {
   private final IdCardService idCardService;

    @PostMapping("/api/idCard/user")
    public UserBlock saveUser(@RequestBody UserInformationSaveRequestDto requestDto){
        return idCardService.save(requestDto);
    }

    @PostMapping("/api/idCard/fingerPrint")
    public long saveFingerPrint(@RequestBody FingerPrintSaveRequestDto requestDto){
        return idCardService.save(requestDto);
    }

    @PostMapping("/api/idCard/facePhoto")
    public long saveFacePhoto(@RequestBody FacePhotoSaveRequestDto requestDto){
        return idCardService.save(requestDto);
    }
}
