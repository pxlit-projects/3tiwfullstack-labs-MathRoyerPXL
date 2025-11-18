package be.pxl.services.domain;

import be.pxl.services.domain.dto.EmployeeDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "organization")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;

    @Transient
    private List<EmployeeDTO> employees;

    @Transient
    private List<DepartmentDTO> departments;
}