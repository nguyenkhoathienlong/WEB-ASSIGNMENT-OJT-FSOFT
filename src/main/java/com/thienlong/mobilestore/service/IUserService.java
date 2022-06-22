package com.thienlong.mobilestore.service;

import com.thienlong.mobilestore.entity.Userss;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    Userss create(Userss userss);
    void save(Userss userss);
    void delete(Integer id);
    Optional<Userss> findByID(Integer id);
    List<Userss> findAll();


}
