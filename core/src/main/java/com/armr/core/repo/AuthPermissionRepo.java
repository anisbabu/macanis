package com.armr.core.repo;


import com.armr.core.model.AuthPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthPermissionRepo extends JpaRepository<AuthPermission, UUID> {
   // Optional<AuthUser> findByUsername(String username);
}
