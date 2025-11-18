package be.pxl.services.controller;

import be.pxl.services.domain.Department;
import be.pxl.services.services.IDepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final IDepartmentService departmentService;

    @PostMapping("/")
    public ResponseEntity<Department> add(@RequestBody Department department) {
        return new ResponseEntity<>(departmentService.add(department), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> findById(@PathVariable Long id) {
        return departmentService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(departmentService.findAll());
    }

    @GetMapping("/organization/{organizationId}")
    public ResponseEntity<?> findByOrganization(@PathVariable Long organizationId) {
        return ResponseEntity.ok(departmentService.findByOrganization(organizationId));
    }

    @GetMapping("/organization/{organizationId}/with-employees")
    public ResponseEntity<?> findByOrganizationWithEmployees(@PathVariable Long organizationId) {
        return ResponseEntity.ok(departmentService.findByOrganizationWithEmployees(organizationId));
    }
}