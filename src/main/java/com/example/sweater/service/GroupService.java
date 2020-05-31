package com.example.sweater.service;

import com.example.sweater.domain.Group;
import com.example.sweater.repos.GroupRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService {

    private GroupRepo groupRepo;

    @Autowired
    public void setGroupRepo(GroupRepo groupRepo) {
        this.groupRepo = groupRepo;
    }

    public List<Group> allGroups(){
        return (List<Group>) groupRepo.findAll();
    }

    public Group getGroupById(Long id ){
        return groupRepo.findById(id).get();

    }

    public void delete(Group group ){
        groupRepo.delete(group);

    }

    public Group saveGroup(Group group){
        groupRepo.save(group);
        return group;
    }

    public List<Group> getAllGroupsByCipher(String cipher){
        return groupRepo.findAllByCipher(cipher);
    }



}
