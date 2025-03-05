package com.armr.core.service;

import com.armr.core.model.AuthUser;
import com.armr.core.model.Company;
import com.armr.core.repo.AuthPermissionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AuthPermissionService {
    @Autowired
    private AuthPermissionRepo repo;

    public List<Company> findUserActiveCompany(AuthUser authUser) {
        return repo.findCompanyByAuthUser(authUser, LocalDate.now());
    }
}
