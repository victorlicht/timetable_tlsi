package com.victorlicht.timetable_tlsi.accounts.dto;

import com.victorlicht.timetable_tlsi.accounts.models.AccountType;
import com.victorlicht.timetable_tlsi.accounts.models.Gender;
import com.victorlicht.timetable_tlsi.accounts.models.Wilaya;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
public class AccountUserDto {

    private String id;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    private String firstName;

    private String lastName;

    private String username;

    private String email;

    private String password;

    private String confirmationPassword;

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
