package com.victorlicht.timetable_tlsi.accounts.service;

import com.victorlicht.timetable_tlsi.accounts.dto.AccountUserDto;
import com.victorlicht.timetable_tlsi.accounts.mapper.AccountUserMapper;
import com.victorlicht.timetable_tlsi.accounts.models.AccountType;
import com.victorlicht.timetable_tlsi.accounts.models.AccountUser;
import com.victorlicht.timetable_tlsi.accounts.models.Gender;
import com.victorlicht.timetable_tlsi.accounts.models.Wilaya;
import com.victorlicht.timetable_tlsi.accounts.repository.AccountUserRepository;
import com.victorlicht.timetable_tlsi.accounts.repository.AccountUserSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public List<AccountUserDto> getAllAccountUsers() {
        List<AccountUser> accountUserList = accountUserRepository.findAll();
        List<AccountUserDto> accountUserDtoList = new ArrayList<>();
        for (AccountUser accountUser : accountUserList) {
            AccountUserDto accountUserDto = AccountUserMapper.convertEntityToDto(accountUser);
            accountUserDtoList.add(accountUserDto);
        }
        return accountUserDtoList;
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

        return accountUserPage.map(AccountUserMapper::convertEntityToDto);
    }

    @Override
    public AccountUserDto updateAccountUserByUsername(String username, AccountUserDto updatedUserDto) throws ChangeSetPersister.NotFoundException {
        try {
            // Find the existing user by username
            AccountUser existingUser = accountUserRepository.findByUsername(username)
                    .orElseThrow(ChangeSetPersister.NotFoundException::new);

            // Update the fields you want to allow modification
            existingUser.setFirstName(updatedUserDto.getFirstName());
            existingUser.setLastName(updatedUserDto.getLastName());
            existingUser.setEmail(updatedUserDto.getEmail());
            existingUser.setGender(updatedUserDto.getGender());
            existingUser.setWilaya(updatedUserDto.getWilaya());
            existingUser.setDateOfBirth(updatedUserDto.getDateOfBirth());

            // Save the updated user
            AccountUser savedUser = accountUserRepository.save(existingUser);

            // Convert the updated user back to DTO

            return AccountUserMapper.convertEntityToDto(savedUser);
        } catch (ChangeSetPersister.NotFoundException e) {
            throw new ChangeSetPersister.NotFoundException();
        } catch (Exception e) {
            throw new RuntimeException("Error updating user", e);
        }
    }


    @Override
    public AccountUserDto findByUsername(String username) {
        Optional<AccountUser> accountUser = accountUserRepository.findByUsername(username);
        return accountUser.map(AccountUserMapper::convertEntityToDto).orElse(null);
    }
}

