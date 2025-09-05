package com.lisandro.botpedidos.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lisandro.botpedidos.Repository.IUserSecRepository;
import com.lisandro.botpedidos.model.UserSec;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserSecRepository userSecRepository;

    @Override
    public List<UserSec> findAll() {
        return userSecRepository.findAll();
    }

    @Override
    public Optional<UserSec> findById(Long id) {
        return userSecRepository.findById(id);
    }

    @Override
    public UserSec save(UserSec user) {
        return userSecRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userSecRepository.deleteById(id);
    }

    @Override
    public UserSec update(UserSec user) {
        return userSecRepository.save(user);
    }

    @Override
    public String encriptPassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }

}
