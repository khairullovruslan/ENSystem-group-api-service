package org.apiservice.controllers;



import groupservice.DTO.GroupDTO;
import groupservice.models.Group;
import groupservice.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {
    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping
    public ResponseEntity<Void> addNewGroup(@RequestBody GroupDTO group){
        groupService.save(group);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Group> getGroupById(@PathVariable("id") long id){
        return new ResponseEntity<>(groupService.showById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Group>> getAllGroups(){
        return new ResponseEntity<>(groupService.getAllGroups(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteGroup(@PathVariable("id") long id){
        groupService.deleteGroupById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
