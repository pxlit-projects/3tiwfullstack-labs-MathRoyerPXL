package be.pxl.services.services;

import be.pxl.services.domain.Organization;

import java.util.Optional;

public interface IOrganizationService {
    Optional<Organization> findById(Long id);
    Optional<Organization> findByIdWithEmployees(Long id);
    Optional<Organization> findByIdWithDepartments(Long id);
    Optional<Organization> findByIdWithDepartmentsAndEmployees(Long id);
}