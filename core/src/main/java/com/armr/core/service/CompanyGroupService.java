@Service
@RequiredArgsConstructor
class CompanyGroupService {
    private final CompanyGroupRepository repository;

    public List<CompanyGroup> getAll() {
        return repository.findAll();
    }

    public Optional<CompanyGroup> getById(UUID id) {
        return repository.findById(id);
    }

    public CompanyGroup save(CompanyGroup companyGroup) {
        return repository.save(companyGroup);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}