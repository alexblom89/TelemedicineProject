package com.Telemedicine.Telemedicine.Repositories;

import com.Telemedicine.Telemedicine.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository  extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
