package com.Telemedicine.Telemedicine.Repositories;

import com.Telemedicine.Telemedicine.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
