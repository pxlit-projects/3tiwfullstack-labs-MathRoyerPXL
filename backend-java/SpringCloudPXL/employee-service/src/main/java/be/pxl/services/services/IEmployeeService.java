package be.pxl.services.services;

import be.pxl.services.domain.Employee;
import be.pxl.services.domain.EmployeeRequest;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    Employee add(Employee employee);
    Optional<Employee> getById(Long id);
    List<Employee> getAllEmployees();
    List<Employee> getByDepartment(Long departmentId);
    List<Employee> getByOrganization(Long organizationId);
    void createEmployee(EmployeeRequest employeeRequest);
}