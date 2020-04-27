package com.trashteam.web;


import com.trashteam.service.idCard.IdCardService;
import com.trashteam.web.dto.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;

@RequiredArgsConstructor
@RestController
@Slf4j
public class IdCardApiController {
   private final IdCardService idCardService;
    public static final Path path = Paths.get(System.getProperty("user.home"), ".upload");

    @PostMapping("/upload")
    public void fileUpload(@RequestParam("file") MultipartFile file) {
        idCardService.fileUpload(file);
        return;
    }

    @GetMapping("/api/idCard/UserBlock")
    public UserDataDto save_block(Model model){
        UserDataDto dto = idCardService.getUserBlock();
        model.addAttribute("user", dto);
        return dto;
    }
}
