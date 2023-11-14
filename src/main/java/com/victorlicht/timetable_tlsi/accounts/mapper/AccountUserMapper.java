package com.victorlicht.timetable_tlsi.accounts.mapper;

import com.victorlicht.timetable_tlsi.accounts.dto.AccountUserDto;
import com.victorlicht.timetable_tlsi.accounts.models.AccountUser;

public class AccountUserMapper {
    public static AccountUserDto toDto(AccountUser accountUser) {
        AccountUserDto accountUserDto = new AccountUserDto();
        accountUserDto.setAccountType(accountUser.getAccountType());
        accountUserDto.setFirstName(accountUser.getFirstName());
        accountUserDto.setLastName(accountUser.getLastName());
        accountUserDto.setUsername(accountUser.getUsername());
        accountUserDto.setEmail(accountUser.getEmail());
        accountUserDto.setPassword(accountUser.getPassword());
        accountUserDto.setConfirmationPassword(accountUser.getConfirmationPassword());
        accountUserDto.setGender(accountUser.getGender());
        accountUserDto.setWilaya(accountUser.getWilaya());
        accountUserDto.setDateOfBirth(accountUser.getDateOfBirth());
        accountUserDto.setBiography(accountUser.getBiography());
        accountUserDto.setProfilePicture(accountUser.getProfilePicture());
        accountUserDto.setPhoneNumber(accountUser.getPhoneNumber());

        return accountUserDto;
    }

    public static AccountUser toEntity(AccountUserDto accountUserDto) {
        AccountUser accountUser = new AccountUser();
        accountUser.setAccountType(accountUserDto.getAccountType());
        accountUser.setFirstName(accountUserDto.getFirstName());
        accountUser.setLastName(accountUserDto.getLastName());
        accountUser.setUsername(accountUserDto.getUsername());
        accountUser.setEmail(accountUserDto.getEmail());
        accountUser.setPassword(accountUserDto.getPassword());
        accountUser.setConfirmationPassword(accountUserDto.getConfirmationPassword());
        accountUser.setGender(accountUserDto.getGender());
        accountUser.setWilaya(accountUserDto.getWilaya());
        accountUser.setDateOfBirth(accountUserDto.getDateOfBirth());
        accountUser.setBiography(accountUserDto.getBiography());
        accountUser.setProfilePicture(accountUserDto.getProfilePicture());
        accountUser.setPhoneNumber(accountUserDto.getPhoneNumber());

        return accountUser;
    }

    public static void updateEntityFromDto(AccountUserDto accountUserDto, AccountUser accountUser) {
        if (accountUserDto.getAccountType() != null) {
            accountUser.setAccountType(accountUserDto.getAccountType());
        }
        if (accountUserDto.getFirstName() != null) {
            accountUser.setFirstName(accountUserDto.getFirstName());
        }
        if (accountUserDto.getLastName() != null) {
            accountUser.setLastName(accountUserDto.getLastName());
        }
        if (accountUserDto.getUsername() != null) {
            accountUser.setUsername(accountUserDto.getUsername());
        }
        if (accountUserDto.getEmail() != null) {
            accountUser.setEmail(accountUserDto.getEmail());
        }
        if (accountUserDto.getPassword() != null) {
            accountUser.setPassword(accountUserDto.getPassword());
        }
        if (accountUserDto.getConfirmationPassword() != null) {
            accountUser.setConfirmationPassword(accountUserDto.getConfirmationPassword());
        }
        if (accountUserDto.getGender() != null) {
            accountUser.setGender(accountUserDto.getGender());
        }
        if (accountUserDto.getWilaya() != null) {
            accountUser.setWilaya(accountUserDto.getWilaya());
        }
        if (accountUserDto.getDateOfBirth() != null) {
            accountUser.setDateOfBirth(accountUserDto.getDateOfBirth());
        }
        if (accountUserDto.getBiography() != null) {
            accountUser.setBiography(accountUserDto.getBiography());
        }
        if (accountUserDto.getProfilePicture() != null) {
            accountUser.setProfilePicture(accountUserDto.getProfilePicture());
        }
        if (accountUserDto.getPhoneNumber() != null) {
            accountUser.setPhoneNumber(accountUserDto.getPhoneNumber());
        }
    }
}
