package com.lisandro.botpedidos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lisandro.botpedidos.model.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {

}
