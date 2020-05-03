package com.trashteam.service.idCard;

import com.trashteam.domain.photo.FacePhoto;
import com.trashteam.domain.photo.FacePhotoRepository;
import com.trashteam.tool.GenerateKey;
import com.trashteam.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

import static org.springframework.util.StringUtils.*;

@RequiredArgsConstructor
@Service
public class IdCardService {
    private final FacePhotoRepository facePhotoRepository;
    private final GenerateKey generateKey;

    @Transactional
    public long save(FacePhotoSaveRequestDto requestDto){
        requestDto.setPrivateKey(generateKey.getPrivateKey());
        return facePhotoRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public UserDataDto getUserBlock(TextDataDto textDataDto){
        FacePhoto facePhoto = facePhotoRepository.findRecentOne().orElseThrow(()
                -> new IllegalArgumentException("error"));
        return new UserDataDto(textDataDto.getTextData(), facePhoto.getPrivateKey());
    }

    @Transactional
    public FacePhotoResponseDto facePhotoFindByPrivateKey(String facePhotoPrivateKey){
        FacePhoto facePhotoEntity = facePhotoRepository.findByPrivateKey(facePhotoPrivateKey).orElseThrow(() -> new IllegalArgumentException("해당 사진이 없습니다."));
        return new FacePhotoResponseDto(facePhotoEntity);
    }

    @Transactional
    public void delete (String fingerPrintPrivateKey, String facePhotoPrivateKey){
        FacePhoto facePhoto = facePhotoRepository.findByPrivateKey(facePhotoPrivateKey).orElseThrow(()
                -> new IllegalArgumentException("해당 사진이 없습니다"));
        facePhotoRepository.delete(facePhoto);
    }
}