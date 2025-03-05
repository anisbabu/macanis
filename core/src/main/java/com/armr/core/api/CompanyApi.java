package com.armr.core.api;

import com.armr.core.model.Company;
import com.armr.core.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/companies")
@RequiredArgsConstructor
class CompanyApi {
    @Autowired
    private CompanyService service;
    
    @GetMapping
    public List<Company> getAll() {
        return service.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Company> getById(@PathVariable String id) {
        return service.getById(id);
    }
    
    @PostMapping
    public Company create(@RequestBody Company company) {
        return service.save(company);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
