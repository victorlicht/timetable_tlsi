package com.victorlicht.timetable_tlsi.accounts.controller;

import com.victorlicht.timetable_tlsi.accounts.models.AccountType;
import com.victorlicht.timetable_tlsi.accounts.models.AccountUser;
import com.victorlicht.timetable_tlsi.accounts.models.Gender;
import com.victorlicht.timetable_tlsi.accounts.models.Wilaya;
import com.victorlicht.timetable_tlsi.accounts.service.AccountUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/admin/users")
public class AccountUserController {

    private final AccountUserService accountUserService;

    @Autowired
    public AccountUserController(AccountUserService accountUserService) {
        this.accountUserService = accountUserService;
    }

    @PostMapping("/create")
    public ResponseEntity<AccountUser> createAccountUser(@RequestBody AccountUser accountUser) {
        AccountUser createdUser = accountUserService.createAccountUser(accountUser);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AccountUser>> getAllAccountUsers() {
        List<AccountUser> accountUsers = accountUserService.getAllAccountUsers();
        return new ResponseEntity<>(accountUsers, HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<Page<AccountUser>> findUsersDynamically(
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
        Page<AccountUser> result = accountUserService.findUsersDynamically(
                phoneNumber, firstName, lastName, email, username,
                dateOfBirth, gender, wilaya, accountType,
                orderByField, sortOrder, pageable
        );
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/update/{username}")
    public ResponseEntity<AccountUser> updateByUsername(@PathVariable String username,@RequestBody AccountUser updatedUser) {
        try {
            AccountUser existingUser = accountUserService.findByUsername(username)
                    .orElseThrow(ChangeSetPersister.NotFoundException::new);
            existingUser.setFirstName(updatedUser.getFirstName());
            existingUser.setLastName(updatedUser.getLastName());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setGender(updatedUser.getGender());
            existingUser.setWilaya(updatedUser.getWilaya());
            existingUser.setDateOfBirth(updatedUser.getDateOfBirth());

            AccountUser savedUser = accountUserService.updateAccountUser(existingUser);
            return new ResponseEntity<>(savedUser, HttpStatus.OK);
        } catch (ChangeSetPersister.NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
