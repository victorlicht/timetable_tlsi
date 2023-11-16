package com.victorlicht.timetable_tlsi.specialities.controller;

import com.victorlicht.timetable_tlsi.specialities.dto.SpecialityDto;
import com.victorlicht.timetable_tlsi.specialities.model.Major;
import com.victorlicht.timetable_tlsi.specialities.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/specialities")
public class SpecialityController {

    private final SpecialityService specialityService;

    @Autowired
    public SpecialityController(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @PostMapping("/create")
    public ResponseEntity<SpecialityDto> createSpeciality(@RequestBody SpecialityDto specialityDto) {
        SpecialityDto createdSpeciality = specialityService.createSpeciality(specialityDto);
        return new ResponseEntity<>(createdSpeciality, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SpecialityDto>> getAllSpecialities() {
        List<SpecialityDto> specialities = specialityService.findAll();
        return ResponseEntity.ok(specialities);
    }

    @DeleteMapping("/{specialityCode}")
    public ResponseEntity<Void> deleteSpeciality(@PathVariable String specialityCode) {
        specialityService.deleteSpecialityBySpecialityCode(specialityCode);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/code/{specialityCode}")
    public ResponseEntity<SpecialityDto> getSpecialityByCode(@PathVariable String specialityCode) {
        SpecialityDto specialityDto = specialityService.findSpecialityBySpecialityCode(specialityCode);
        return ResponseEntity.ok(specialityDto);
    }

    @GetMapping("/by-major/{major}")
    public ResponseEntity<List<SpecialityDto>> getSpecialityByMajor(@PathVariable Major major) {
        List<SpecialityDto> specialities = specialityService.findSpecialityByMajor(major);
        return ResponseEntity.ok(specialities);
    }

    @GetMapping("/by-name/{specialityName}")
    public ResponseEntity<SpecialityDto> getSpecialityByName(@PathVariable String specialityName) {
        SpecialityDto specialityDto = specialityService.findSpecialityBySpecialityName(specialityName);
        return ResponseEntity.ok(specialityDto);
    }
}
