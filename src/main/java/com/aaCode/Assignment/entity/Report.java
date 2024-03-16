package com.aaCode.Assignment.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "report")
public class Report {

    @Id
    @Column(name = "report_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String patient_name;
    private String test_name;
    private String doctor_name;
    private String result;
    private String date;

}
