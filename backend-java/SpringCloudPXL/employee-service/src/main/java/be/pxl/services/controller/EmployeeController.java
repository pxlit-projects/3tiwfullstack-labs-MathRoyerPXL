package be.pxl.services.controller;

import be.pxl.services.domain.Employee;
import be.pxl.services.services.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final IEmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> add(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.add(employee), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Long id) {
        return employeeService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/department/{departmentId}")
    public ResponseEntity<?> findByDepartment(@PathVariable Long departmentId) {
        return ResponseEntity.ok(employeeService.getByDepartment(departmentId));
    }

    @GetMapping("/organization/{organizationId}")
    public ResponseEntity<?> findByOrganization(@PathVariable Long organizationId) {
        return ResponseEntity.ok(employeeService.getByOrganization(organizationId));
    }
}