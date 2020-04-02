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
//db와 viewer 사이 트랜잭션 서비스
@RequiredArgsConstructor
@Service
public class IdCardService {
    private final FingerPrintRepository fingerPrintRepository;
    private final FacePhotoRepository facePhotoRepository;
    private final GenerateKey generateKey;

    @Transactional
    public UserBlock save(UserInformationSaveRequestDto requestDto){
        requestDto.setFacePhotoPrivateKey(generateKey.getFacePhotoPrivateKey());
        requestDto.setFingerPrintPrivateKey(generateKey.getFingerPrintPrivateKey());
        return requestDto.userBlockObject();
    }

    @Transactional
    public long save(FingerPrintSaveRequestDto requestDto){
        requestDto.setPrivateKey(generateKey.getFingerPrintPrivateKey());
        fingerPrintRepository.save(requestDto.toEntity());
        return 0;
    }

    @Transactional
    public long save(FacePhotoSaveRequestDto requestDto){
        requestDto.setPrivateKey(generateKey.getFacePhotoPrivateKey());
        facePhotoRepository.save(requestDto.toEntity()).getPrivateKey();
        return 0;
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