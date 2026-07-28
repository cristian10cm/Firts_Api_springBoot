package com.cruz.medicaments_api.medicaments.services;

import com.cruz.medicaments_api.medicaments.dto.MedicineCreateDto;
import com.cruz.medicaments_api.medicaments.dto.MedicineResponseDto;
import com.cruz.medicaments_api.medicaments.dto.MedicineUpdateDto;
import com.cruz.medicaments_api.medicaments.entity.Medicine;
import com.cruz.medicaments_api.medicaments.mapper.MedicineMapper;
import com.cruz.medicaments_api.medicaments.ports.MedicinePortRepository;
import com.cruz.medicaments_api.medicaments.repository.MedicineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService implements MedicinePortRepository {
    private final MedicineRepository medicineRepository;
    private final MedicineMapper medicineMapper;

    public MedicineService(
            MedicineRepository medicineRepository,
            MedicineMapper medicineMapper){
        this.medicineRepository = medicineRepository;
        this.medicineMapper = medicineMapper;
    }

    public List<MedicineResponseDto> getAllMedicines(){
        List<Medicine> medicines = medicineRepository.findAll();
        return  medicineMapper.toListmedicines(medicines);
    }

    public MedicineResponseDto getMedicineById(Long id){
        Medicine response = medicineRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Medicine not found")
        )
                ;
        return medicineMapper.toDto(response);
    }

    public void CreateMedicine(MedicineCreateDto dto){
        Medicine toEntity = medicineMapper.toEntity(dto);
        medicineRepository.save(toEntity);
    }
    public  String deleteMedicine(long id){
        Medicine response = medicineRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Medicine not found")
        );
         medicineRepository.deleteById(response.getId());
        return "Delete success";
    }
    public MedicineResponseDto updateMedicine(
            long id, MedicineUpdateDto dto
    ){
        Medicine response = medicineRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Medicine not found")
        );

        if (dto.name() != null) {
            response.setName(dto.name());
        }

        if (dto.price() != null) {
            response.setPrice(dto.price());
        }
        if (dto.symptoms() != null) {
            response.setSymptoms(dto.symptoms());
        }
        Medicine re = medicineRepository.save(response);
        return  medicineMapper.toDto(re);
    }
}
