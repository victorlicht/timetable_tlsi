package com.victorlicht.timetable_tlsi.sessions.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SessionTime {
    SESSION_1("8:30 - 10:00"),
    SESSION_2("10:00 - 11:30"),
    SESSION_3("11:30 - 13:00"),
    SESSION_4("13:00 - 14:30"),
    SESSION_5("14:30 - 16:00");

    private final String timeRange;
}
