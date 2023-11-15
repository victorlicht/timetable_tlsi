package com.victorlicht.timetable_tlsi.accounts.controllers;

import com.victorlicht.timetable_tlsi.accounts.dtos.AccountUserDto;
import com.victorlicht.timetable_tlsi.accounts.mappers.AccountUserMapper;
import com.victorlicht.timetable_tlsi.accounts.models.AccountType;
import com.victorlicht.timetable_tlsi.accounts.models.AccountUser;
import com.victorlicht.timetable_tlsi.accounts.models.Gender;
import com.victorlicht.timetable_tlsi.accounts.models.Wilaya;
import com.victorlicht.timetable_tlsi.accounts.services.AccountUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize
    ) {

        // Validate the page size to the allowed values (10, 25, 50)
        if (!(pageSize == 10 || pageSize == 25 || pageSize == 50)) {
            return ResponseEntity.badRequest().build();
        }

        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<AccountUserDto> users = accountUserService.findUsersDynamically(
                phoneNumber, firstName, lastName, email, username,
                dateOfBirth, gender, wilaya, accountType, orderByField, sortOrder, pageable
        );
        return ResponseEntity.ok(users);
    }

    @PostMapping("/create")
    public ResponseEntity<AccountUserDto> createAccountUser(@RequestBody AccountUserDto accountUserDto) {
        AccountUser createdUser = accountUserService.createAccountUser(AccountUserMapper.toEntity(accountUserDto));
        return new ResponseEntity<>(AccountUserMapper.toDto(createdUser), HttpStatus.CREATED);
    }

    @PutMapping("/update/{username}")
    public ResponseEntity<AccountUserDto> updateAccountUserByUsername(
            @PathVariable String username,
            @RequestBody AccountUserDto updatedUserDto) {
        try {
            // Retrieve the existing user entity from the service layer
            AccountUser existingUser = accountUserService.findByUsername(username);

            if (existingUser != null) {
                // Update the fields with the provided data from updatedUserDto
                // Assuming your mapper maps the fields properly between the DTO and entity
                // Update the existing user entity through the service
                AccountUserDto savedUserDto = accountUserService.updateAccountUser(updatedUserDto, existingUser);
                return ResponseEntity.ok(savedUserDto);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
