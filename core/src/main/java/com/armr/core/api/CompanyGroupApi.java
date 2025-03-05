package com.armr.core.api;

import com.armr.core.model.CompanyGroup;
import com.armr.core.service.CompanyGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

// API Controller
@RestController
@RequestMapping("/api/company-groups")

class CompanyGroupApi {
    private final CompanyGroupService service;

    public CompanyGroupApi(CompanyGroupService service){
        this.service = service;
    }
    
    @GetMapping
    public List<CompanyGroup> getAll() {
        return service.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<CompanyGroup> getById(@PathVariable String id) {
        return service.getById(id);
    }
    
    @PostMapping
    public CompanyGroup create(@RequestBody CompanyGroup companyGroup) {
        return service.save(companyGroup);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}