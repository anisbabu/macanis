package com.armr.core.repo;

import com.armr.core.model.CompanyGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CompanyGroupRepository extends JpaRepository<CompanyGroup, UUID> {

}
