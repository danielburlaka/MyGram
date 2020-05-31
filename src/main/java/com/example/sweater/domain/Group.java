package com.example.sweater.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "stud_gr")
@Data
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cipher_gr")
    private String cipher;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @OneToMany(mappedBy = "groupOfStuds", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Student> students = new ArrayList<>();


    public void addStudent(Student student){
        students.add(student);
        student.setGroupOfStuds(this);
    }

    public void delStudent(Student student){
        students.remove(student);
    }


}

