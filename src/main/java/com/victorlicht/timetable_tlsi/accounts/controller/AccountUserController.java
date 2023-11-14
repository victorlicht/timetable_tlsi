package com.victorlicht.timetable_tlsi.accounts.controller;

import com.victorlicht.timetable_tlsi.accounts.dto.AccountUserDto;
import com.victorlicht.timetable_tlsi.accounts.models.AccountType;
import com.victorlicht.timetable_tlsi.accounts.models.AccountUser;
import com.victorlicht.timetable_tlsi.accounts.models.Gender;
import com.victorlicht.timetable_tlsi.accounts.models.Wilaya;
import com.victorlicht.timetable_tlsi.accounts.service.AccountUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@RequestMapping("/api/v1/admin/users")
public class AccountUserController {

    private final AccountUserServiceImpl accountUserService;

    @Autowired
    public AccountUserController(AccountUserServiceImpl accountUserService) {
        this.accountUserService = accountUserService;
    }

    @PostMapping("/create")
    public ResponseEntity<AccountUser> createAccountUser(@RequestBody AccountUser accountUser) {
        AccountUser createdUser = accountUserService.createAccountUser(accountUser);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<AccountUserDto>> findUsersDynamically(
            @RequestParam(required = false) String phoneNumber,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) Date dateOfBirth,
            @RequestParam(required = false) Gender gender,
            @RequestParam(required = false) Wilaya wilaya,
            @RequestParam(required = false) AccountType accountType,
            @RequestParam(required = false) String orderByField,
            @RequestParam(defaultValue = "ASC") String sortOrder,
            Pageable pageable
    ) {
        Page<AccountUserDto> result = accountUserService.findUsersDynamically(
                phoneNumber, firstName, lastName, email, username,
                dateOfBirth, gender, wilaya, accountType,
                orderByField, sortOrder, pageable
        );
        return ResponseEntity.ok(result);
    }

    @PutMapping("/update/{username}")
    public ResponseEntity<AccountUserDto> updateByUsername(
            @PathVariable String username,
            @RequestBody @Validated AccountUserDto updatedUserDto) {
        try {
            AccountUserDto savedUserDto = accountUserService.updateAccountUserByUsername(username, updatedUserDto);
            return ResponseEntity.ok(savedUserDto);
        } catch (ChangeSetPersister.NotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}