package com.example.sweater.service;

import com.example.sweater.domain.Faculty;
import com.example.sweater.domain.Student;
import com.example.sweater.repos.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepo studentRepo;


    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }


    public List<Student> allStudents(){
        return (List<Student>)studentRepo.findAll();
    }


    public Student saveStudent(Student student){
        studentRepo.save(student);
        return student;
    }

    public void delete(Student student){
        studentRepo.delete(student);
    }

    public Student getById(Long id){
        return studentRepo.findById(id).get();
    }

    public List<Student> getAllStudentsByCardNumber(Integer cardNumber){
        return studentRepo.findAllByCardNumber(cardNumber);
    }

    public List<Student> getAllStudentsByName(String fullName){
        return studentRepo.findAllByFullName(fullName);
    }

    public List<Student> findAllByFaculties(Faculty faculty){
        return studentRepo.findAllByFacultyEquals(faculty);
    }



}
