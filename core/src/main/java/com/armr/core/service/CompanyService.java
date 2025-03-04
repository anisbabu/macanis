package com.armr.core.service;

import com.armr.core.model.Company;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository repository;
    
    public List<Company> getAll() {
        return repository.findAll();
    }
    
    public Optional<Company> getById(UUID id) {
        return repository.findById(id);
    }
    
    public Company save(Company company) {
        return repository.save(company);
    }
    
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}