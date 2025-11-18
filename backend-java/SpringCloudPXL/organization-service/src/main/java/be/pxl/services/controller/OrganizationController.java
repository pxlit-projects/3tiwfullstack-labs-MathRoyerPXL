package be.pxl.services.controller;

import be.pxl.services.domain.Organization;
import be.pxl.services.services.IOrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/organization")
@RequiredArgsConstructor
public class OrganizationController {

    private final IOrganizationService organizationService;

    @GetMapping("/{id}")
    public ResponseEntity<Organization> findById(@PathVariable Long id) {
        return organizationService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/with-departments")
    public ResponseEntity<Organization> findByIdWithDepartments(@PathVariable Long id) {
        return organizationService.findByIdWithDepartments(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/with-departments-and-employees")
    public ResponseEntity<Organization> findByIdWithDepartmentsAndEmployees(@PathVariable Long id) {
        return organizationService.findByIdWithDepartmentsAndEmployees(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/with-employees")
    public ResponseEntity<Organization> findByIdWithEmployees(@PathVariable Long id) {
        return organizationService.findByIdWithEmployees(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}