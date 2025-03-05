package com.armr.core.service;

import com.armr.core.model.Company;
import com.armr.core.repo.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepo repository;
    
    public List<Company> getAll() {
        return repository.findAll();
    }
    
    public Optional<Company> getById(String id) {
        return repository.findById(id);
    }
    
    public Company save(Company company) {
        return repository.save(company);
    }
    
    public void delete(String id) {
        repository.deleteById(id);
    }
}