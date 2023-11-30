package com.victorlicht.timetable_tlsi.accounts.services;

import com.victorlicht.timetable_tlsi.accounts.dtos.AccountUserDto;
import com.victorlicht.timetable_tlsi.accounts.mappers.AccountUserMapper;
import com.victorlicht.timetable_tlsi.accounts.models.AccountType;
import com.victorlicht.timetable_tlsi.accounts.models.AccountUser;
import com.victorlicht.timetable_tlsi.accounts.models.Gender;
import com.victorlicht.timetable_tlsi.accounts.models.Wilaya;
import com.victorlicht.timetable_tlsi.accounts.repositories.AccountUserRepository;
import com.victorlicht.timetable_tlsi.accounts.repositories.AccountUserSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class AccountUserServiceImpl implements AccountUserService {

    private final AccountUserRepository accountUserRepository;

    @Autowired
    public AccountUserServiceImpl(AccountUserRepository accountUserRepository) {
        this.accountUserRepository = accountUserRepository;
    }

    @Override
    public AccountUser createAccountUser(AccountUser accountUser) {
        return accountUserRepository.save(accountUser);
    }

    @Override
    public Page<AccountUserDto> findUsersDynamically(
            String phoneNumber,
            String firstName,
            String lastName,
            String email,
            String username,
            Date dateOfBirth,
            Gender gender,
            Wilaya wilaya,
            AccountType accountType,
            String orderByField,
            String sortOrder,
            Pageable pageable
    ) {
        Page<AccountUser> accountUserPage = accountUserRepository.findAll(
                AccountUserSpecifications.filterAndOrder(
                        phoneNumber, firstName, lastName, email, username,
                        dateOfBirth, gender, wilaya, accountType,
                        orderByField, sortOrder
                ),
                pageable
        );

        return accountUserPage.map(AccountUserMapper::toDto);

    }

    @Override
    public AccountUser findByUsername(String username) {
        return accountUserRepository.findByUsername(username).orElse(null);
    }

    @Override
    public AccountUserDto updateAccountUser(AccountUserDto accountUserDto, AccountUser updatedUser) {
        AccountUserMapper.updateEntityFromDto(accountUserDto, updatedUser);
        return AccountUserMapper.toDto(accountUserRepository.save(updatedUser));
    }

    @Override
    public void deleteAccountUser(AccountUser accountUser) {
        accountUserRepository.delete(accountUser);
    }
}

