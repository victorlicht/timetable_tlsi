package com.victorlicht.timetable_tlsi.specialities.service;

import com.victorlicht.timetable_tlsi.specialities.dto.SpecialityDto;
import com.victorlicht.timetable_tlsi.specialities.model.Major;

import java.util.List;

public interface SpecialityService {
    void deleteSpecialityBySpecialityCode(String specialityCode);
    SpecialityDto findSpecialityBySpecialityCode(String specialityCode);
    List<SpecialityDto> findSpecialityByMajor(Major major);
    SpecialityDto findSpecialityBySpecialityName(String specialityName);
    SpecialityDto createSpeciality(SpecialityDto specialityDto);
    List<SpecialityDto> findAll();
}
