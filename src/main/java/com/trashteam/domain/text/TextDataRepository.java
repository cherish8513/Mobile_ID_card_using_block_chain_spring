package com.trashteam.domain.text;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TextDataRepository extends JpaRepository<TextData, Long> {
}
