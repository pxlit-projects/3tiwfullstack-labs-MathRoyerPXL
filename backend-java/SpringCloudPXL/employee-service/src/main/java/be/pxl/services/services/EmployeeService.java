package be.pxl.services.services;

import be.pxl.services.client.NotificationClient;
import be.pxl.services.domain.Employee;
import be.pxl.services.domain.EmployeeRequest;
import be.pxl.services.domain.NotificationRequest;
import be.pxl.services.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService implements IEmployeeService {

    private final EmployeeRepository employeeRepository;
    private final NotificationClient notificationClient;

    @Override
    public void createEmployee(EmployeeRequest employeeRequest) {
        Employee employee = Employee.builder()
                .age(employeeRequest.getAge())
                .Name(employeeRequest.getName())
                .position(employeeRequest.getPosition())
                .build();
        employeeRepository.save(employee);

        NotificationRequest notificationRequest =
                NotificationRequest.builder()
                        .message("Employee created")
                        .sender("Math")
                        .build();

        notificationClient.sendNotification(notificationRequest);
    }

    @Override
    public Employee add(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> getById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> getByDepartment(Long departmentId) {
        return employeeRepository.findByDepartmendId(departmentId);
    }

    @Override
    public List<Employee> getByOrganization(Long organizationId) {
        return employeeRepository.findByOrganizationId(organizationId);
    }
}