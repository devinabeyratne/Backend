package com.aaCode.Assignment.dto;

import lombok.Data;

@Data
public class ReportDTO {

    private Long id;
    private String patient_name;
    private String test_name;
    private String doctor_name;
    private String result;
    private String date;
}
