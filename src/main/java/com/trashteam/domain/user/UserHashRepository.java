package com.trashteam.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserHashRepository extends JpaRepository<UserHash, Long> {
    @Query("SELECT p FROM UserHash p WHERE p.application_id = :id")
    UserHash findByAppId(@Param("id")String id);

    //Optional<UserHash> findByApplication_id(String application_id);
}
