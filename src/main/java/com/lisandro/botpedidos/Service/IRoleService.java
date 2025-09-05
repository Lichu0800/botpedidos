package com.lisandro.botpedidos.Service;

import java.util.List;
import java.util.Optional;

import com.lisandro.botpedidos.model.Role;

public interface IRoleService {

    List<Role> findAll();

    Optional<Role> findById(Long id);

    Role saveRole(Role role);

    void deleteById(Long id);

    Role updatRole(Role role);

}
