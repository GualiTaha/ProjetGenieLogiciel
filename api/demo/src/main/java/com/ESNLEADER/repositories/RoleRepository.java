package com.ESNLEADER.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ESNLEADER.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
