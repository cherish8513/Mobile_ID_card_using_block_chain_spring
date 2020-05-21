package com.trashteam.domain.photo;

import com.trashteam.domain.user.UserHash;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FacePhotoRepository extends JpaRepository<FacePhoto, Long> {
    @Query(value = "SELECT * FROM face_photo WHERE private_key=:key limit 1", nativeQuery = true)
    FacePhoto findByPrivateKey(@Param("key")String key);
}
