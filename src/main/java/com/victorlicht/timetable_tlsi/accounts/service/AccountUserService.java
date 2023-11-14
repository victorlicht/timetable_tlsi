package com.victorlicht.timetable_tlsi.accounts.service;

import com.victorlicht.timetable_tlsi.accounts.dto.AccountUserDto;
import com.victorlicht.timetable_tlsi.accounts.models.AccountType;
import com.victorlicht.timetable_tlsi.accounts.models.AccountUser;
import com.victorlicht.timetable_tlsi.accounts.models.Gender;
import com.victorlicht.timetable_tlsi.accounts.models.Wilaya;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Date;

interface AccountUserService {

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

    AccountUserDto updateAccountUserByUsername(String username, AccountUserDto updatedUserDto) throws ChangeSetPersister.NotFoundException;

    AccountUser findByUsername(String username);

    AccountUserDto updateAccountUser(AccountUserDto accountUserDto, AccountUser updatedUser);
}
