package com.cruz.medicaments_api.medicaments.controller;

import com.cruz.medicaments_api.medicaments.dto.MedicineCreateDto;
import com.cruz.medicaments_api.medicaments.dto.MedicineResponseDto;
import com.cruz.medicaments_api.medicaments.dto.MedicineUpdateDto;
import com.cruz.medicaments_api.medicaments.services.MedicineService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicines")
public class MedicineController {
    private final MedicineService medicineService;
    MedicineController(MedicineService medicineService){
            this.medicineService = medicineService;
    }
    @GetMapping
    public List<MedicineResponseDto> getAllMedicines(){
        return  medicineService.getAllMedicines();
    }
    @GetMapping("/{id}")

    public MedicineResponseDto getById(@PathVariable long id){
            return  medicineService.getMedicineById(id);
    }
    @PostMapping
    public void createMedicine(@Valid @RequestBody MedicineCreateDto md){
       medicineService.CreateMedicine(md);
    }

    @DeleteMapping("/{id}")

    public  String deleteById(@PathVariable long id){
        return  medicineService.deleteMedicine(id);
    }
    @PatchMapping("/{id}")

    public MedicineResponseDto updateMedicine(@PathVariable long id, @Valid @RequestBody MedicineUpdateDto dto  ){
        return  medicineService.updateMedicine(id,dto);
    }

}
