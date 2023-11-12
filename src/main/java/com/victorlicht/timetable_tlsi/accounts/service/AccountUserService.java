package com.victorlicht.timetable_tlsi.accounts.service;

import com.victorlicht.timetable_tlsi.accounts.models.AccountType;
import com.victorlicht.timetable_tlsi.accounts.models.AccountUser;
import com.victorlicht.timetable_tlsi.accounts.models.Gender;
import com.victorlicht.timetable_tlsi.accounts.models.Wilaya;
import com.victorlicht.timetable_tlsi.accounts.repository.AccountUserRepository;
import com.victorlicht.timetable_tlsi.accounts.repository.AccountUserSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AccountUserService {

    private final AccountUserRepository accountUserRepository;

    @Autowired
    public AccountUserService(AccountUserRepository accountUserRepository) {
        this.accountUserRepository = accountUserRepository;
    }

    public AccountUser createAccountUser(AccountUser accountUser) {
        return accountUserRepository.save(accountUser);
    }


    public List<AccountUser> getAllAccountUsers() {
        return accountUserRepository.findAll();
    }

    public Page<AccountUser> findUsersDynamically(
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
    ) {
        return accountUserRepository.findAll(
                AccountUserSpecifications.filterAndOrder(
                        phoneNumber, firstName, lastName, email, username,
                        dataOfBirth, gender, wilaya, accountType,
                        orderByField, sortOrder
                ),
                pageable
        );
    }

    public AccountUser updateAccountUser(AccountUser accountUser) {
        return accountUserRepository.save(accountUser);
    }

    public Optional<AccountUser> findByUsername(String username) {
        return accountUserRepository.findByUsername(username);
    }

}
