package com.lisandro.botpedidos.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lisandro.botpedidos.model.Permission;

@Repository
public interface IPermissionRepository extends JpaRepository<Permission, Long> {

}
