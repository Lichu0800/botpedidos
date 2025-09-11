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
import com.lisandro.botpedidos.model.Role;
import com.lisandro.botpedidos.service.IRoleService;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    @Autowired
    private IRoleService roleService;
    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles(){
        List<Role> roleList = roleService.findAll();
        return ResponseEntity.ok(roleList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Long id ){
        Optional <Role> newRole = roleService.findById(id);
        return newRole.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody Role role){
        Role newRole = roleService.saveRole(role);
        return ResponseEntity.ok(newRole);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole (@PathVariable Long id){
        Optional<Role> role = roleService.findById(id);
        if (role.isPresent()){
            roleService.deleteById(id);
            return ResponseEntity.noContent().build();   
        } else{
            return ResponseEntity.notFound().build();
        }
    }

}
