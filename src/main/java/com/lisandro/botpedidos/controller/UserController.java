package com.lisandro.botpedidos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lisandro.botpedidos.model.UserSec;
import com.lisandro.botpedidos.service.IUserService;


@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping
    public ResponseEntity<List<UserSec>> getAllUsers(){
        List<UserSec> userList = userService.findAll();
        return ResponseEntity.ok(userList);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserSec> findById(@PathVariable Long id){
        Optional <UserSec> user = userService.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UserSec> createUser(@RequestBody UserSec user){
        UserSec newUser = userService.save(user);
        return ResponseEntity.ok(newUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        Optional<UserSec> user = userService.findById(id);
        if (user.isPresent()){
            userService.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }

    }

}
