package com.example.sweater.repos;

import com.example.sweater.domain.Faculty;
import com.example.sweater.domain.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends CrudRepository<Student, Long> {

    List<Student> findAllByFacultyEquals(Faculty faculty);
    List<Student> findAllByCardNumber(Integer cardNumber);
    List<Student> findAllByFullName(String fullName);
}
