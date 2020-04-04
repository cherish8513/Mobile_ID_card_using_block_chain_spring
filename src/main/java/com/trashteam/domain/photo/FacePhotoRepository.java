package com.trashteam.domain.photo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FacePhotoRepository extends JpaRepository<FacePhoto, String> {
    Optional<FacePhoto> findByPrivateKey(String privateKey);
}
