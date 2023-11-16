package com.victorlicht.timetable_tlsi.specialities.mapper;

import com.victorlicht.timetable_tlsi.specialities.dto.SpecialityDto;
import com.victorlicht.timetable_tlsi.specialities.model.Speciality;

import java.util.List;
import java.util.stream.Collectors;

public class SpecialityMapper {
    public static Speciality toEntity(SpecialityDto specialityDto) {
        Speciality speciality = new Speciality();
        speciality.setMajor(specialityDto.getMajor());
        speciality.setSpecialityName(specialityDto.getSpecialityName());
        speciality.setSpecialityCode(specialityDto.getSpecialityCode());
        speciality.setDescription(specialityDto.getDescription());

        return speciality;
    }

    public static SpecialityDto toDto(Speciality speciality) {
        SpecialityDto specialityDto = new SpecialityDto();
        specialityDto.setMajor(speciality.getMajor());
        specialityDto.setSpecialityName(speciality.getSpecialityName());
        specialityDto.setSpecialityCode(speciality.getSpecialityCode());
        specialityDto.setDescription(speciality.getDescription());

        return specialityDto;
    }

    public static List<SpecialityDto> toDtoList(List<Speciality> specialities) {
        return specialities.stream()
                .map(SpecialityMapper::toDto)
                .collect(Collectors.toList());
    }
}
