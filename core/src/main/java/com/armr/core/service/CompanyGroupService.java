package com.armr.core.service;

import com.armr.core.model.CompanyGroup;
import com.armr.core.repo.CompanyGroupRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CompanyGroupService {

    private final CompanyGroupRepo repository;

    public CompanyGroupService(CompanyGroupRepo repository) {
        this.repository = repository;
    }

    public List<CompanyGroup> getAll() {
        return repository.findAll();
    }

    public Optional<CompanyGroup> getById(String id) {
        return repository.findById(id);
    }

    public CompanyGroup save(CompanyGroup companyGroup) {
        return repository.save(companyGroup);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}