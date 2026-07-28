package com.cruz.medicaments_api.medicaments.repository;

import com.cruz.medicaments_api.medicaments.dto.MedicineResponseDto;
import com.cruz.medicaments_api.medicaments.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedicineRepository extends JpaRepository<Medicine,Long> {
    Optional<Medicine> findByName(String name);
}
