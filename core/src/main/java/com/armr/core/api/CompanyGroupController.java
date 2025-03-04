package com.armr.core.api;

// API Controller
@RestController
@RequestMapping("/api/company-groups")
@RequiredArgsConstructor
class CompanyGroupController {
    private final CompanyGroupService service;
    
    @GetMapping
    public List<CompanyGroup> getAll() {
        return service.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<CompanyGroup> getById(@PathVariable UUID id) {
        return service.getById(id);
    }
    
    @PostMapping
    public CompanyGroup create(@RequestBody CompanyGroup companyGroup) {
        return service.save(companyGroup);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}