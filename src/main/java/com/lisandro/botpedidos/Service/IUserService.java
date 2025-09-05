package com.lisandro.botpedidos.Service;

import java.util.List;
import java.util.Optional;

import com.lisandro.botpedidos.model.UserSec;

public interface IUserService {

    List<UserSec> findAll();

    Optional<UserSec> findById(Long id);

    UserSec save(UserSec user);

    void deleteById(Long id);

    UserSec update(UserSec user);

    String encriptPassword(String password);

}
