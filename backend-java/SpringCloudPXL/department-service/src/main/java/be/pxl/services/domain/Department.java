package be.pxl.services.domain;

import be.pxl.services.domain.dto.EmployeeDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "department")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long organizationId;
    private String name;
    private String position;

    @Transient
    private List<EmployeeDTO> employees;
}