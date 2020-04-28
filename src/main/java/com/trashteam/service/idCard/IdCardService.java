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

import static org.springframework.util.StringUtils.*;

@RequiredArgsConstructor
@Service
public class IdCardService {
    private final FacePhotoRepository facePhotoRepository;
    private final GenerateKey generateKey;

    @Transactional
    public long save(FacePhotoSaveRequestDto requestDto){
        requestDto.setPrivateKey(generateKey.getPrivateKey());
        facePhotoRepository.save(requestDto.toEntity());
        return facePhotoRepository.count();
    }

    @Transactional
    public UserDataDto getUserBlock(){
        return new UserDataDto(generateKey.getPrivateKey());
    }

    // application.properties 에 app.upload.dir을 정의하고, 없는 경우에 default 값으로 user.home (System에 종속적인)
    @Value("/photo")
    private String uploadDir;

    public void fileUpload(MultipartFile multipartFile) {
        // File.seperator 는 OS종속적이다.
        // Spring에서 제공하는 cleanPath()를 통해서 ../ 내부 점들에 대해서 사용을 억제한다
        Path copyOfLocation = Paths.get(uploadDir + File.separator + cleanPath(multipartFile.getOriginalFilename()));
        try {
            // inputStream을 가져와서
            // copyOfLocation (저장위치)로 파일을 쓴다.
            // copy의 옵션은 기존에 존재하면 REPLACE(대체한다), 오버라이딩 한다
            Files.copy(multipartFile.getInputStream(), copyOfLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

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