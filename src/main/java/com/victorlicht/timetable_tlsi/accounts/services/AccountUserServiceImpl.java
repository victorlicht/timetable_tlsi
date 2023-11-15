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
import org.springframework.data.crossstore.ChangeSetPersister;
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
    public AccountUserDto updateAccountUserByUsername(String username, AccountUserDto updatedUserDto) throws ChangeSetPersister.NotFoundException {
        try {
            AccountUser existingUser = accountUserRepository.findByUsername(username)
                    .orElseThrow(ChangeSetPersister.NotFoundException::new);

            // Update fields from DTO if they are not null
            existingUser.setFirstName(updatedUserDto.getFirstName() != null ? updatedUserDto.getFirstName() : existingUser.getFirstName());
            existingUser.setLastName(updatedUserDto.getLastName() != null ? updatedUserDto.getLastName() : existingUser.getLastName());
            existingUser.setEmail(updatedUserDto.getEmail() != null ? updatedUserDto.getEmail() : existingUser.getEmail());
            existingUser.setGender(updatedUserDto.getGender() != null ? updatedUserDto.getGender() : existingUser.getGender());
            existingUser.setWilaya(updatedUserDto.getWilaya() != null ? updatedUserDto.getWilaya() : existingUser.getWilaya());
            existingUser.setDateOfBirth(updatedUserDto.getDateOfBirth() != null ? updatedUserDto.getDateOfBirth() : existingUser.getDateOfBirth());

            AccountUser savedUser = accountUserRepository.save(existingUser);
            return AccountUserMapper.toDto(savedUser);
        } catch (ChangeSetPersister.NotFoundException e) {
            throw new ChangeSetPersister.NotFoundException();
        } catch (Exception e) {
            throw new RuntimeException("Error updating user", e);
        }
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
}

