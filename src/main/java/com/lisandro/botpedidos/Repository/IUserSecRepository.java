package com.lisandro.botpedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lisandro.botpedidos.model.UserSec;

@Repository
public interface IUserSecRepository extends JpaRepository<UserSec, Long> {

}
