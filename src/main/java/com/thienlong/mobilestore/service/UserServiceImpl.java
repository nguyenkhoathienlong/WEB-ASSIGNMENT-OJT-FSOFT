package com.thienlong.mobilestore.service;

import com.thienlong.mobilestore.entity.Userss;
import com.thienlong.mobilestore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository IUserRepository;

    @Override
    public Userss create(Userss users) {
        if(users.getUserName().isEmpty()) {
            return null;
        }
        if(users.getID() == null){
            return null;
        }
        return IUserRepository.save(users);
    }

    @Override
    public void save(Userss users) {
        IUserRepository.save(users);
    }

    @Override
    public void delete(Integer id) {
        IUserRepository.deleteById(id);
    }

    @Override
    public Optional<Userss> findByID(Integer id) {
        return IUserRepository.findById(id);
    }

    @Override
    public List<Userss> findAll() {
        return IUserRepository.findAll();
    }
}
