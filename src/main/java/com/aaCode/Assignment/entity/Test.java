package com.aaCode.Assignment.entity;

import com.aaCode.Assignment.dto.TestDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "test")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_id", nullable = false)
    private Long id;
    private String name;
    private String description;
    private String price;

    @ManyToOne
    @JoinColumn(name = "technician_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Technician technician;

    public TestDTO getDTO(){
        TestDTO testDTO = new TestDTO();

        testDTO.setId(id);
        testDTO.setName(name);
        testDTO.setDescription(description);
        testDTO.setDescription(price);
        testDTO.setTechnicianId(technician.getId());
        testDTO.setTechnicianName(technician.getName());

        return testDTO;

    }



}
