package com.example.sweater.service;

import com.example.sweater.domain.Faculty;
import com.example.sweater.repos.FacultyRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FacultyService {


    private FacultyRepo facultyRepo;

    @Autowired
    public void setFacultyRepo(FacultyRepo facultyRepo) {
        this.facultyRepo = facultyRepo;
    }

    public List<Faculty> allFaculties(){
        return (List<Faculty>) facultyRepo.findAll();
    }


    public Faculty getFacultyById(Long id){
        return facultyRepo.findById(id).get();

    }

    public void delete(Faculty faculty){
        facultyRepo.delete(faculty);

    }


    public Faculty saveFaculty(Faculty faculty){
        facultyRepo.save(faculty);
        return faculty;
    }

    public List<Faculty> getAllFacultiesByName(String name){
        return facultyRepo.findAllByName(name);
    }





}
