package com.armr.core.repo;


import com.armr.core.model.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepo extends JpaRepository<AuthUser, UUID> {
    Optional<AuthUser> findByUsername(String username);
}
