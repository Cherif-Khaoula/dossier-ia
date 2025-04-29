package com.example.dossiers_service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DossierRepository extends JpaRepository<DossierCME, Long> {
    List<DossierCME> findByChargeDossierId(Long chargeDossierId);
    List<DossierCME> findByTypePassation(TypePassation typePassation);

}
