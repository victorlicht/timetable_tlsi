package com.victorlicht.timetable_tlsi.accounts.controllers;

import com.victorlicht.timetable_tlsi.accounts.dtos.AccountUserDto;
import com.victorlicht.timetable_tlsi.accounts.mappers.AccountUserMapper;
import com.victorlicht.timetable_tlsi.accounts.models.AccountType;
import com.victorlicht.timetable_tlsi.accounts.models.AccountUser;
import com.victorlicht.timetable_tlsi.accounts.models.Gender;
import com.victorlicht.timetable_tlsi.accounts.models.Wilaya;
import com.victorlicht.timetable_tlsi.accounts.services.AccountUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@RequestMapping("/api/v1/users")
public class AccountUserController {

    private final AccountUserService accountUserService;


    @Autowired
    public AccountUserController(AccountUserService accountUserService) {
        this.accountUserService = accountUserService;
    }

    @GetMapping("/admin/find")
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
        if (!(pageSize == 10 || pageSize == 25 || pageSize == 50)) {
            return ResponseEntity.badRequest().build();
        }
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<AccountUserDto> users = accountUserService.findUsersDynamically(
                phoneNumber, firstName, lastName, email, username,
                dateOfBirth, gender, wilaya, accountType,
                orderByField, sortOrder, pageable
        );
        return ResponseEntity.ok(users);
    }

    @PostMapping("/admin/create")
    public ResponseEntity<AccountUserDto> createAccountUser(
            @RequestBody(required = false) AccountUserDto accountUserDto) {
        AccountUser createdUser = accountUserService.createAccountUser(AccountUserMapper.toEntity(accountUserDto));
        return new ResponseEntity<>(AccountUserMapper.toDto(createdUser), HttpStatus.CREATED);
    }

    @PutMapping("/admin/update/{username}")
    public ResponseEntity<AccountUserDto> updateAccountUserByUsername(
            @PathVariable String username,
            @RequestBody AccountUserDto updatedUserDto) {
        try {
            AccountUser existingUser = accountUserService.findByUsername(username);
            if (existingUser != null) {
                AccountUserDto savedUserDto = accountUserService
                                            .updateAccountUser(updatedUserDto, existingUser);
                return ResponseEntity.ok(savedUserDto);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
