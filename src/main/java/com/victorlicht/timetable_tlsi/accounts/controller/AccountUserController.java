package com.victorlicht.timetable_tlsi.accounts.controller;

import com.victorlicht.timetable_tlsi.accounts.models.AccountUser;
import com.victorlicht.timetable_tlsi.accounts.service.AccountUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account-users")
public class AccountUserController {

    private final AccountUserService accountUserService;

    @Autowired
    public AccountUserController(AccountUserService accountUserService) {
        this.accountUserService = accountUserService;
    }

    // Create a new AccountUser
    @PostMapping
    public ResponseEntity<AccountUser> createAccountUser(@RequestBody AccountUser accountUser) {
        AccountUser createdUser = accountUserService.createAccountUser(accountUser);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    // Retrieve an AccountUser by ID
    @GetMapping("/{id}")
    public ResponseEntity<AccountUser> getAccountUserById(@PathVariable String id) {
        return accountUserService.getAccountUserById(id)
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Retrieve all AccountUsers
    @GetMapping
    public ResponseEntity<List<AccountUser>> getAllAccountUsers() {
        List<AccountUser> accountUsers = accountUserService.getAllAccountUsers();
        return new ResponseEntity<>(accountUsers, HttpStatus.OK);
    }

    // Update an existing AccountUser
    @PutMapping("/{id}")
    public ResponseEntity<AccountUser> updateAccountUser(@PathVariable String id, @RequestBody AccountUser accountUser) {
        accountUser.setId(id);
        AccountUser updatedUser = accountUserService.updateAccountUser(accountUser);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    // Delete an AccountUser by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccountUser(@PathVariable String id) {
        accountUserService.deleteAccountUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
