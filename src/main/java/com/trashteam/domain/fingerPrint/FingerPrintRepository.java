package com.trashteam.domain.fingerPrint;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
//Fingerprint db 기능
public interface FingerPrintRepository extends JpaRepository<FingerPrint, String> {
    Optional<FingerPrint> findByPrivateKey(String privateKey);
}
