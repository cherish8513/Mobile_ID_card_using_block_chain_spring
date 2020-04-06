package com.trashteam.service.idCard;

import com.trashteam.block.UserBlock;
import com.trashteam.domain.fingerPrint.FingerPrint;
import com.trashteam.domain.fingerPrint.FingerPrintRepository;
import com.trashteam.domain.photo.FacePhoto;
import com.trashteam.domain.photo.FacePhotoRepository;
import com.trashteam.tool.GenerateKey;
import com.trashteam.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@RequiredArgsConstructor
@Service
public class IdCardService {
    private final FingerPrintRepository fingerPrintRepository;
    private final FacePhotoRepository facePhotoRepository;
    private final GenerateKey generateKey;

    @Transactional
    public UserBlock save(UserInformationSaveRequestDto requestDto){
        requestDto.setFacePhotoPrivateKey(generateKey.getPrivateKey());
        requestDto.setFingerPrintPrivateKey(generateKey.getPrivateKey());
        return requestDto.userBlockObject();
    }

    @Transactional
    public long save(FingerPrintSaveRequestDto requestDto){
        requestDto.setPrivateKey(generateKey.getPrivateKey());
        fingerPrintRepository.save(requestDto.toEntity());
        return fingerPrintRepository.count();
    }

    @Transactional
    public long save(FacePhotoSaveRequestDto requestDto){
        requestDto.setPrivateKey(generateKey.getPrivateKey());
        facePhotoRepository.save(requestDto.toEntity());
        return facePhotoRepository.count();
    }


    @Transactional
    public FacePhotoResponseDto facePhotoFindByPrivateKey(String facePhotoPrivateKey){
        FacePhoto facePhotoEntity = facePhotoRepository.findByPrivateKey(facePhotoPrivateKey).orElseThrow(() -> new IllegalArgumentException("해당 사진이 없습니다."));
        return new FacePhotoResponseDto(facePhotoEntity);
    }

    @Transactional
    public FingerPrintResponseDto fingerPrintFindByPrivateKey(String fingerPrintPrivateKey){
        FingerPrint fingerPrintEntity = fingerPrintRepository.findByPrivateKey(fingerPrintPrivateKey).orElseThrow(() -> new IllegalArgumentException("해당 지문이 없습니다."));
        return new FingerPrintResponseDto(fingerPrintEntity);
    }

    @Transactional
    public void delete (String fingerPrintPrivateKey, String facePhotoPrivateKey){
        FingerPrint fingerPrint = fingerPrintRepository.findByPrivateKey(fingerPrintPrivateKey).orElseThrow(()
                -> new IllegalArgumentException("해당 지문이 없습니다"));
        FacePhoto facePhoto = facePhotoRepository.findByPrivateKey(facePhotoPrivateKey).orElseThrow(()
                -> new IllegalArgumentException("해당 사진이 없습니다"));
        fingerPrintRepository.delete(fingerPrint);
        facePhotoRepository.delete(facePhoto);
    }
}