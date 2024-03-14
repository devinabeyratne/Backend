package com.aaCode.Assignment.dto;

import com.aaCode.Assignment.entity.Technician;
import lombok.Data;

@Data
public class TestDTO {

    private Long id;
    private String name;
    private String description;
    private String price;
    private Long technicianId;

}
