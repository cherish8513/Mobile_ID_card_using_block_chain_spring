package com.trashteam.web.dto;


import com.trashteam.tool.GenerateKey;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
//JSON객체 테스트
@RunWith(SpringRunner.class)
@SpringBootTest
public class FacePhotoSaveRequestDtoTest{
    @Autowired
    private GenerateKey generateKey;

    @Test
    public void save() throws Exception{
       FacePhotoSaveRequestDto requestDto = FacePhotoSaveRequestDto.builder()
               .imgUrl("king")
               .imgName("hungmin")
               .build();

       requestDto.setPrivateKey(generateKey.getFacePhotoPrivateKey());

        Assertions.assertThat(requestDto.getImgName()).isEqualTo("hungmin");
        Assertions.assertThat(requestDto.getImgUrl()).isEqualTo("king");
        Assertions.assertThat(requestDto.getPrivateKey()).isEqualTo(generateKey.getFacePhotoPrivateKey());
    }
}