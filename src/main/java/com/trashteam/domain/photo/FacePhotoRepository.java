package com.trashteam.domain.photo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
//facePhoto db 기능
public interface FacePhotoRepository extends JpaRepository<FacePhoto, String> {
    Optional<FacePhoto> findByPrivateKey(String privateKey);
}
