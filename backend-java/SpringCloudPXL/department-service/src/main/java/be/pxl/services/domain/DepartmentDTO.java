package be.pxl.services.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {
    private Long id;
    private Long organizationId;
    private String name;
    private String position;
    private List<EmployeeDTO> employees;
}