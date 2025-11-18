package be.pxl.services.services;

import be.pxl.services.domain.DepartmentDTO;
import be.pxl.services.domain.dto.EmployeeDTO;
import be.pxl.services.domain.Organization;
import be.pxl.services.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrganizationService implements IOrganizationService {

    private final OrganizationRepository organizationRepository;

    // adjust base URLs/ports to your deployment
    private final RestClient employeeClient = RestClient.builder()
            .baseUrl("http://localhost:8081")
            .build();
    private final RestClient departmentClient = RestClient.builder()
            .baseUrl("http://localhost:8082")
            .build();

    @Override
    public Optional<Organization> findById(Long id) {
        return organizationRepository.findById(id);
    }

    @Override
    public Optional<Organization> findByIdWithEmployees(Long id) {
        return organizationRepository.findById(id).map(org -> {
            List<EmployeeDTO> employees = employeeClient.get()
                    .uri("/api/employee/organization/{orgId}", id)
                    .retrieve()
                    .body(new ParameterizedTypeReference<List<EmployeeDTO>>() {});
            org.setEmployees(employees);
            return org;
        });
    }

    @Override
    public Optional<Organization> findByIdWithDepartments(Long id) {
        return organizationRepository.findById(id).map(org -> {
            List<DepartmentDTO> departments = departmentClient.get()
                    .uri("/api/department/organization/{orgId}", id)
                    .retrieve()
                    .body(new ParameterizedTypeReference<List<DepartmentDTO>>() {});
            org.setDepartments(departments);
            return org;
        });
    }

    @Override
    public Optional<Organization> findByIdWithDepartmentsAndEmployees(Long id) {
        return organizationRepository.findById(id).map(org -> {
            // Departments with nested employees (if department-service populates them)
            List<DepartmentDTO> departments = departmentClient.get()
                    .uri("/api/department/organization/{orgId}/with-employees", id)
                    .retrieve()
                    .body(new ParameterizedTypeReference<List<DepartmentDTO>>() {});
            org.setDepartments(departments);

            // Also expose a flat employees list
            List<EmployeeDTO> employees = employeeClient.get()
                    .uri("/api/employee/organization/{orgId}", id)
                    .retrieve()
                    .body(new ParameterizedTypeReference<List<EmployeeDTO>>() {});
            org.setEmployees(employees);
            return org;
        });
    }
}