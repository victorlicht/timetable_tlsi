package com.victorlicht.timetable_tlsi.accounts.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.sql.Date;

@Setter
@Getter
@Accessors(chain = true)
@Entity
public class AccountUser {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String id;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Column(length = 128, nullable = false)
    private String firstName;

    @Column(length = 128, nullable = false)
    private String lastName;

    @Column(length = 16, unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(length = 60, nullable = false)
    private String password;

    @Column(length = 60, nullable = false)
    private String confirmationPassword;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Wilaya wilaya = Wilaya.CONSTANTINE;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String biography;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String profilePicture;

    @Column(length = 10, unique = true, nullable = false)
    private String phoneNumber;
}
