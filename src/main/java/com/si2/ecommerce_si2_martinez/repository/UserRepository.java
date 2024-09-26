package com.si2.ecommerce_si2_martinez.repository;

import com.si2.ecommerce_si2_martinez.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


    public User findByEmail(String email);

}
