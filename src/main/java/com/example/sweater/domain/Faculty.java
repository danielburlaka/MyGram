package com.example.sweater.domain;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "faculty")
@Data
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "faculty_name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "dec_full_name")
    private String decanName;

    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Group> groups = new ArrayList<>();

    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Student> students = new ArrayList<>();

    public void addGroup(Group group){
        groups.add(group);
        group.setFaculty(this);
    }

    public void delGroup(Group group){
        groups.remove(group);
    }


    public void addStudent(Student student){
        students.add(student);
        student.setFaculty(this);
    }

    public void delStudent(Student student){
        students.remove(student);
    }


}
