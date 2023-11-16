package com.victorlicht.timetable_tlsi.classrooms.service;

import com.victorlicht.timetable_tlsi.classrooms.dto.ClassroomDto;
import com.victorlicht.timetable_tlsi.classrooms.mapper.ClassroomMapper;
import com.victorlicht.timetable_tlsi.classrooms.model.Classroom;
import com.victorlicht.timetable_tlsi.classrooms.model.ClassroomType;
import com.victorlicht.timetable_tlsi.classrooms.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomServiceImpl implements ClassroomService{

    private final ClassroomRepository classroomRepository;

    @Autowired
    public ClassroomServiceImpl(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    @Override
    public ClassroomDto createClassroom(ClassroomDto classroomDto) {
        return ClassroomMapper.toDto(classroomRepository.save(ClassroomMapper.toEntity(classroomDto)));
    }

    @Override
    public void deleteClassroomByClassroomNumberAndClassroomType(int classroomNumber, ClassroomType classroomType) {
        classroomRepository.deleteClassroomByClassroomNumberAndClassroomType(classroomNumber, classroomType);
    }

    @Override
    public List<ClassroomDto> findByClassroomType(ClassroomType classroomType) {
        return classroomRepository.findByClassroomType(classroomType);
    }

    @Override
    public ClassroomDto findClassroomByClassroomNumber(int classroomNumber) {
        return classroomRepository.findClassroomByClassroomNumber(classroomNumber);
    }

    @Override
    public List<ClassroomDto> findAll() {
        List<Classroom> classrooms = classroomRepository.findAll();
        return ClassroomMapper.toDtoList(classrooms);
    }
}
