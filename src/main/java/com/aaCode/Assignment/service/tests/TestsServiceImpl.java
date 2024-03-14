package com.aaCode.Assignment.service.tests;

import com.aaCode.Assignment.dto.TechnicianDTO;
import com.aaCode.Assignment.dto.TestsDTO;
import com.aaCode.Assignment.entity.Technician;
import com.aaCode.Assignment.entity.Tests;
import com.aaCode.Assignment.repository.TechnicianRepo;
import com.aaCode.Assignment.repository.TestsRepo;
import com.aaCode.Assignment.service.technician.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestsServiceImpl implements TestsService {

    private final TestsRepo testsRepo;

    @Autowired
    public TestsServiceImpl(TestsRepo testsRepo) {
        this.testsRepo = testsRepo;
    }

    public Tests createTests(TestsDTO testsDTO){
        Tests tests = new Tests();

        tests.setName(testsDTO.getName());
        tests.setPrice(testsDTO.getPrice());
        tests.setDescription(testsDTO.getDescription());
        tests.setTechnician_name(testsDTO.getTechnician_name());

        return testsRepo.save(tests);
    }

    public List<Tests> getAllTests(){
        return testsRepo.findAll();
    }


}
