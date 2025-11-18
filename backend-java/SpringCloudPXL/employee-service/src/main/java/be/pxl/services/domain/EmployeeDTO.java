package be.pxl.services.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private Long id;
    private Long organizationId;
    private Long departmendId;
    private String name;
    private int age;
    private String position;
}