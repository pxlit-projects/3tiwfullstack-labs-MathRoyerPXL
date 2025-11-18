package be.pxl.services.services;

import be.pxl.services.domain.Department;

import java.util.List;
import java.util.Optional;

public interface IDepartmentService {
    Department add(Department department);
    Optional<Department> findById(Long id);
    List<Department> findAll();
    List<Department> findByOrganization(Long organizationId);
    List<Department> findByOrganizationWithEmployees(Long organizationId);
}