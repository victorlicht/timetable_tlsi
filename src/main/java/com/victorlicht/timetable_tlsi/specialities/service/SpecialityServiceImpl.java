package com.victorlicht.timetable_tlsi.specialities.service;

import com.victorlicht.timetable_tlsi.specialities.dto.SpecialityDto;
import com.victorlicht.timetable_tlsi.specialities.mapper.SpecialityMapper;
import com.victorlicht.timetable_tlsi.specialities.model.Major;
import com.victorlicht.timetable_tlsi.specialities.model.Speciality;
import com.victorlicht.timetable_tlsi.specialities.repository.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialityServiceImpl implements SpecialityService {
    private final SpecialityRepository specialityRepository;

    @Autowired
    public SpecialityServiceImpl(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public void deleteSpecialityBySpecialityCode(String specialityCode) {
        specialityRepository.deleteSpecialityBySpecialityCode(specialityCode);
    }

    @Override
    public SpecialityDto findSpecialityBySpecialityCode(String specialityCode) {
        Speciality speciality = specialityRepository.findSpecialityBySpecialityCode(specialityCode);
        return SpecialityMapper.toDto(speciality);
    }

    @Override
    public List<SpecialityDto> findSpecialityByMajor(Major major) {
        return SpecialityMapper.toDtoList(specialityRepository.findSpecialityByMajor(major));
    }

    @Override
    public SpecialityDto findSpecialityBySpecialityName(String specialityName) {
        Speciality speciality = specialityRepository.findSpecialityBySpecialityName(specialityName);
        return SpecialityMapper.toDto(speciality);
    }

    @Override
    public SpecialityDto createSpeciality(SpecialityDto specialityDto) {
        Speciality speciality = SpecialityMapper.toEntity(specialityDto);
        Speciality savedSpeciality = specialityRepository.save(speciality);
        return SpecialityMapper.toDto(savedSpeciality);
    }

    @Override
    public List<SpecialityDto> findAll() {
        return SpecialityMapper.toDtoList(specialityRepository.findAll());
    }
}
