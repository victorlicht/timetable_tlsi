package com.victorlicht.timetable_tlsi.specialities.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Major {
    L3("Licence 3"),
    M1("Master 1"),
    M2("Master 2");

    private final String majorCode;
}
