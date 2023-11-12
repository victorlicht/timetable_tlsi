package com.victorlicht.timetable_tlsi.accounts.repository;

import com.victorlicht.timetable_tlsi.accounts.models.AccountUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountUserRepository extends JpaRepository<AccountUser, String>, JpaSpecificationExecutor<AccountUser> {

    //For modified by these
    Optional<AccountUser> findByUsername(String username);
    Optional<AccountUser> findByPhoneNumber(String phoneNumber);
    Optional<AccountUser> findByEmail(String email);
}
