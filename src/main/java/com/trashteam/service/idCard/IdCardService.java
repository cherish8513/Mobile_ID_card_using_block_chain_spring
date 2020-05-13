package com.trashteam.service.idCard;

import com.trashteam.domain.photo.FacePhotoRepository;
import com.trashteam.domain.user.UserHashRepository;
import com.trashteam.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class IdCardService {
    private final FacePhotoRepository facePhotoRepository;
    private final UserHashRepository userHashRepository;

    @Transactional
    public long save_photo(DataSaveRequestDto requestDto) {
        FacePhotoSaveRequestDto facePhotoSaveRequestDto = FacePhotoSaveRequestDto.builder()
                .imgName(requestDto.getImgName())
                .imgUrl(requestDto.getImgUrl())
                .privateKey(requestDto.getPrivateKey())
                .build();
        return facePhotoRepository.save(facePhotoSaveRequestDto.toEntity()).getId();
    }

    @Transactional
    public long save_userId(DataSaveRequestDto requestDto) {
        UserHashSaveRequestDto userHashSaveRequestDto = UserHashSaveRequestDto.builder()
                .application_id(requestDto.getApplication_id())
                .contract_address(requestDto.getContract_address())
                .build();
        return userHashRepository.save(userHashSaveRequestDto.toEntity()).getId();
    }
}