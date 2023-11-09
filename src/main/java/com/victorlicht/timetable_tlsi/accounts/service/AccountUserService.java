package com.victorlicht.timetable_tlsi.accounts.service;

import com.victorlicht.timetable_tlsi.accounts.models.AccountUser;
import com.victorlicht.timetable_tlsi.accounts.repository.AccountUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountUserService {

    private final AccountUserRepository accountUserRepository;

    @Autowired
    public AccountUserService(AccountUserRepository accountUserRepository) {
        this.accountUserRepository = accountUserRepository;
    }

    // Create a new AccountUser
    public AccountUser createAccountUser(AccountUser accountUser) {
        return accountUserRepository.save(accountUser);
    }

    // Retrieve an AccountUser by ID
    public Optional<AccountUser> getAccountUserById(String id) {
        return accountUserRepository.findById(id);
    }

    // Retrieve all AccountUsers
    public List<AccountUser> getAllAccountUsers() {
        return accountUserRepository.findAll();
    }

    // Update an existing AccountUser
    public AccountUser updateAccountUser(AccountUser accountUser) {
        return accountUserRepository.save(accountUser);
    }

    // Delete an AccountUser by ID
    public void deleteAccountUser(String id) {
        accountUserRepository.deleteById(id);
    }
}
