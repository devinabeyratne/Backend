package com.aaCode.Assignment.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "appointment")
public class Appointment {

    @Id
    @Column(name = "appointment_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String age;
    private String dob;
    private String sex;
    private String category;
    private String date;
    private String time;
    private String email;
    private String phone;
}