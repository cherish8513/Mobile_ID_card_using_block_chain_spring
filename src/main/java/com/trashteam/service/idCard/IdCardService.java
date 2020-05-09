package com.trashteam.service.idCard;

import com.trashteam.domain.photo.FacePhoto;
import com.trashteam.domain.photo.FacePhotoRepository;
import com.trashteam.domain.text.TextData;
import com.trashteam.domain.text.TextDataRepository;
import com.trashteam.tool.GenerateKey;
import com.trashteam.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class IdCardService {
    private final FacePhotoRepository facePhotoRepository;
    private final GenerateKey generateKey;
    private final TextDataRepository textDataRepository;

    @Transactional
    public long save(FacePhotoSaveRequestDto requestDto){
        requestDto.setPrivateKey(generateKey.getPrivateKey());
        return facePhotoRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public long save(TextDataSaveRequestDto requestDto){
        List<FacePhoto> facePhoto = facePhotoRepository.findRecentOne();
        requestDto.setPrivateKey(facePhoto.get(0).getPrivateKey());
        return textDataRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public UserDataDto getUserBlock(){
        List<TextData> all = textDataRepository.findAll();
        Long id = all.get(0).getId();
        TextData textData = textDataRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다."));
        UserDataDto userDataDto = UserDataDto.builder()
                .textData(textData.getTextData())
                .privateKey(textData.getPrivateKey())
                .build();
        textDataRepository.delete(all.get(0));
        return userDataDto;
    }
}