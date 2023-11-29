package com.victorlicht.timetable_tlsi.accounts.dtos;

import com.victorlicht.timetable_tlsi.accounts.models.AccountType;
import com.victorlicht.timetable_tlsi.accounts.models.Gender;
import com.victorlicht.timetable_tlsi.accounts.models.Wilaya;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
public class AccountUserDto {

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    private String firstName;

    private String lastName;

    private String username;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Wilaya wilaya = Wilaya.CONSTANTINE;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    private String biography;

    private String profilePicture;

    private String phoneNumber;
}
