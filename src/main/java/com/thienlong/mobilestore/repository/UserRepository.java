package com.thienlong.mobilestore.repository;

import com.thienlong.mobilestore.entity.Userss;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Userss, Integer>, CrudRepository<Userss, Integer> {
}
