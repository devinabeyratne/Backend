package com.aaCode.Assignment.controller;

import com.aaCode.Assignment.dto.TechnicianDTO;
import com.aaCode.Assignment.dto.UsersDTO;
import com.aaCode.Assignment.entity.Technician;
import com.aaCode.Assignment.service.technician.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/technician")
@CrossOrigin("*")
public class TechnicianController {

    private final TechnicianService technicianService;

    @Autowired
    public TechnicianController(TechnicianService technicianService) {
        this.technicianService = technicianService;
    }
    @PostMapping(path = "/createTeachnician")
    public ResponseEntity<Technician> addTechnician(@RequestBody TechnicianDTO technicianDTO){
        Technician technician = technicianService.createTechnician(technicianDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(technician);

    }

    @GetMapping(path = "/getAllTechnician")
    public ResponseEntity<List<Technician>> getAllTech(){
        return ResponseEntity.ok(technicianService.getAllTechnician());
    }

}
