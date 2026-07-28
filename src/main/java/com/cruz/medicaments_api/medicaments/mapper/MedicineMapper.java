package com.cruz.medicaments_api.medicaments.mapper;

import com.cruz.medicaments_api.medicaments.dto.MedicineCreateDto;
import com.cruz.medicaments_api.medicaments.dto.MedicineResponseDto;
import com.cruz.medicaments_api.medicaments.dto.MedicineUpdateDto;
import com.cruz.medicaments_api.medicaments.entity.Medicine;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE

)
public interface MedicineMapper {
    MedicineResponseDto toDto(Medicine dto);
    List<MedicineResponseDto> toListmedicines(List<Medicine> medicines);
    Medicine toEntity(MedicineCreateDto dto);

}
