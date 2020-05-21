package com.trashteam.domain.photo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FacePhotoRepository extends JpaRepository<FacePhoto, Long> {
    Optional<FacePhoto> findByPrivateKey(String privateKey);
}
