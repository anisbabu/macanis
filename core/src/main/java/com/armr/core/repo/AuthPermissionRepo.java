package com.armr.core.repo;


import com.armr.core.model.AuthPermission;
import com.armr.core.model.AuthUser;
import com.armr.core.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface AuthPermissionRepo extends JpaRepository<AuthPermission, String> {

    @Query("select m.company from AuthPermission m where m.authUser=:authUser and :onday between m.effectiveFrom and nvl(m.effectiveTo,:onday) ")
    List<Company> findCompanyByAuthUser(AuthUser authUser, LocalDate onday);

}
