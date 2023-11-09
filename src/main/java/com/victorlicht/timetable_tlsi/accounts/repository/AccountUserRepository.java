package com.victorlicht.timetable_tlsi.accounts.repository;

import com.victorlicht.timetable_tlsi.accounts.models.AccountUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountUserRepository extends JpaRepository<AccountUser, String> {}
