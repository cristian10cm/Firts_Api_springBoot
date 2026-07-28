package com.cruz.medicaments_api.medicaments.ports;

import com.cruz.medicaments_api.medicaments.dto.MedicineCreateDto;
import com.cruz.medicaments_api.medicaments.dto.MedicineResponseDto;

import java.util.List;

public interface MedicinePortRepository {
    List<MedicineResponseDto> getAllMedicines();
    MedicineResponseDto getMedicineById(Long id);
    void CreateMedicine(MedicineCreateDto dto);
    String deleteMedicine(long id);
}
