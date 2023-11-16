package com.victorlicht.timetable_tlsi.accounts.services;

import com.victorlicht.timetable_tlsi.accounts.dtos.AccountUserDto;
import com.victorlicht.timetable_tlsi.accounts.models.AccountType;
import com.victorlicht.timetable_tlsi.accounts.models.AccountUser;
import com.victorlicht.timetable_tlsi.accounts.models.Gender;
import com.victorlicht.timetable_tlsi.accounts.models.Wilaya;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Date;

public interface AccountUserService {

    AccountUser createAccountUser(AccountUser accountUser);

    Page<AccountUserDto> findUsersDynamically(
            String phoneNumber,
            String firstName,
            String lastName,
            String email,
            String username,
            Date dataOfBirth,
            Gender gender,
            Wilaya wilaya,
            AccountType accountType,
            String orderByField,
            String sortOrder,
            Pageable pageable
    );

    AccountUser findByUsername(String username);

    AccountUserDto updateAccountUser(AccountUserDto accountUserDto, AccountUser updatedUser);
}
