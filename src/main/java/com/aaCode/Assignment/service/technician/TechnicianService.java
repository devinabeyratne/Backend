package com.aaCode.Assignment.service.technician;

import com.aaCode.Assignment.dto.TechnicianDTO;
import com.aaCode.Assignment.entity.Technician;

import java.util.List;

public interface TechnicianService {

    Technician createTechnician(TechnicianDTO technicianDTO);

    List<Technician> getAllTechnician();

}
