package com.trashteam.service.idCard;

import com.trashteam.domain.photo.FacePhoto;
import com.trashteam.domain.photo.FacePhotoRepository;
import com.trashteam.domain.user.UserHash;
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
        System.out.println("image_name : " + facePhotoSaveRequestDto.getImgName());
        System.out.println("image_url : " + facePhotoSaveRequestDto.getImgUrl());
        System.out.println("private_key : " + facePhotoSaveRequestDto.getPrivateKey());
        return facePhotoRepository.save(facePhotoSaveRequestDto.toEntity()).getId();
    }

    @Transactional
    public long save_userId(DataSaveRequestDto requestDto) {
        UserHashSaveRequestDto userHashSaveRequestDto = UserHashSaveRequestDto.builder()
                .application_id(requestDto.getApplication_id())
                .contract_address(requestDto.getContract_address())
                .build();
        System.out.println("application_id : " + userHashSaveRequestDto.getApplication_id());
        System.out.println("contract_address : " + userHashSaveRequestDto.getContract_address());
        return userHashRepository.save(userHashSaveRequestDto.toEntity()).getId();
    }

    @Transactional
    public BlockResponseRequestDto load_userId(BlockResponseRequestDto requestDto, String id){
        UserHash userHash = userHashRepository.findByAppId(id);
        //UserHash userHash = userHashRepository.findByApplication_id(id)
        //.orElseThrow(()->new IllegalArgumentException("해당 사용자가 없습니다."));
        requestDto.setContract_address(userHash.getContract_address());
        return requestDto;
    }

    @Transactional
    public PhotoResponseRequestDto load_photo(PhotoResponseRequestDto requestDto, String privateKey){
        FacePhoto facePhoto = facePhotoRepository.findByPrivateKey(privateKey);
        requestDto.setImgName(facePhoto.getImgName());
        requestDto.setImgUrl(facePhoto.getImgUrl());
        return requestDto;
    }
}