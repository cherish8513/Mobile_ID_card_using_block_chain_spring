package com.trashteam.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserHashRepository extends JpaRepository<UserHash, Long> {
    @Query(value = "SELECT * FROM user_hash WHERE application_id=:id limit 1", nativeQuery = true)
    UserHash findByAppId(@Param("id")String id);

    //Optional<UserHash> findByApplication_id(String application_id);
}
