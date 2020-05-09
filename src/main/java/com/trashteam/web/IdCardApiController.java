package com.trashteam.web;


import com.trashteam.domain.text.TextData;
import com.trashteam.service.idCard.IdCardService;
import com.trashteam.web.dto.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.Path;
import java.nio.file.Paths;

@RequiredArgsConstructor
@RestController
public class IdCardApiController {
   private final IdCardService idCardService;

    @PostMapping("/api/idCard/save/photo")
    public Long save(@RequestBody FacePhotoSaveRequestDto requestDto) {
        return idCardService.save(requestDto);
    }

    @PostMapping("/api/idCard/save/text")
    public Long save(@RequestBody TextDataSaveRequestDto requestDto) {
        return idCardService.save(requestDto);
    }

    @GetMapping("/api/idCard/userBlock")
    public UserDataDto save_block(Model model){
        UserDataDto userDataDto = idCardService.getUserBlock();
        model.addAttribute("user", userDataDto);
        System.out.println(userDataDto.getTextData());
        return userDataDto;
    }
}
