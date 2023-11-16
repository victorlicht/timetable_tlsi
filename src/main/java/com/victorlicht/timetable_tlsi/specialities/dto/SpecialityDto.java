package com.victorlicht.timetable_tlsi.specialities.dto;

import com.victorlicht.timetable_tlsi.specialities.model.Major;
import lombok.Data;

@Data
public class SpecialityDto {
    private Major major;

    private String specialityName;

    private String specialityCode;

    private String description;
}
