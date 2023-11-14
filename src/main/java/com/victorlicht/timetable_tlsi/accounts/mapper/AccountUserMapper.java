package com.victorlicht.timetable_tlsi.accounts.mapper;

import com.victorlicht.timetable_tlsi.accounts.dto.AccountUserDto;
import com.victorlicht.timetable_tlsi.accounts.models.AccountUser;

public class AccountUserMapper {

    public static AccountUserDto convertEntityToDto(AccountUser accountUser) {
        AccountUserDto accountUserDto = new AccountUserDto();

        accountUserDto.setId(accountUser.getId());
        accountUserDto.setUsername(accountUser.getUsername());
        accountUserDto.setFirstName(accountUser.getFirstName());
        accountUserDto.setLastName(accountUser.getLastName());
        accountUserDto.setEmail(accountUser.getEmail());
        accountUserDto.setPassword(accountUser.getPassword());
        accountUserDto.setConfirmationPassword(accountUser.getConfirmationPassword());
        accountUserDto.setAccountType(accountUser.getAccountType());
        accountUserDto.setBiography(accountUser.getBiography());
        accountUserDto.setGender(accountUser.getGender());
        accountUserDto.setDateOfBirth(accountUser.getDateOfBirth());
        accountUserDto.setWilaya(accountUser.getWilaya());
        accountUserDto.setPhoneNumber(accountUser.getPhoneNumber());
        accountUserDto.setProfilePicture(accountUser.getProfilePicture());

        return accountUserDto;
    }
}
