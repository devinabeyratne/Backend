package com.aaCode.Assignment.service.technician;

import com.aaCode.Assignment.dto.TechnicianDTO;
import com.aaCode.Assignment.entity.Technician;
import com.aaCode.Assignment.repository.TechnicianRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicianServiceImpl implements TechnicianService{
    private final TechnicianRepo technicianRepo;

    @Autowired
    public TechnicianServiceImpl(TechnicianRepo technicianRepo) {
        this.technicianRepo = technicianRepo;
    }

    public Technician createTechnician(TechnicianDTO technicianDTO){
        Technician technician = new Technician();

        technician.setName(technicianDTO.getName());
        technician.setEmail(technicianDTO.getEmail());
        technician.setSpecialisation(technicianDTO.getSpecialisation());

        return technicianRepo.save(technician);
    }

    public List<Technician> getAllTechnician(){
        return technicianRepo.findAll();
    }


}
