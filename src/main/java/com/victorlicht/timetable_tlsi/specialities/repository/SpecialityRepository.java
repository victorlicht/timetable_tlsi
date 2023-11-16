package com.victorlicht.timetable_tlsi.specialities.repository;

import com.victorlicht.timetable_tlsi.specialities.model.Major;
import com.victorlicht.timetable_tlsi.specialities.model.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality, Long> {
    void deleteSpecialityBySpecialityCode(String specialityCode);
    Speciality findSpecialityBySpecialityCode(String specialityCode);
    List<Speciality> findSpecialityByMajor(Major major);
    Speciality findSpecialityBySpecialityName(String specialityName);
}
