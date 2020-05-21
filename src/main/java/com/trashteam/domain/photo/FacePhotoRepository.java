package com.trashteam.domain.photo;

import com.trashteam.domain.user.UserHash;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FacePhotoRepository extends JpaRepository<FacePhoto, Long> {
    @Query("SELECT p FROM FacePhoto p WHERE p.privateKey = :privateKey")
    FacePhoto findByPrivateKey(@Param("privateKey")String privateKey);
}
