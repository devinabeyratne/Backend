package com.aaCode.Assignment.service.test;

import com.aaCode.Assignment.dto.TestDTO;
import com.aaCode.Assignment.entity.Technician;
import com.aaCode.Assignment.entity.Test;
import com.aaCode.Assignment.repository.TechnicianRepo;
import com.aaCode.Assignment.repository.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    private final TechnicianRepo technicianRepo;
    private final TestRepo testRepo;

    @Autowired
    public TestServiceImpl(TechnicianRepo technicianRepo, TestRepo testRepo) {
        this.technicianRepo = technicianRepo;
        this.testRepo = testRepo;
    }

    public TestDTO createTest(TestDTO testDTO){

        Test test = new Test();

        test.setName(testDTO.getName());
        test.setDescription(testDTO.getDescription());
        test.setPrice(testDTO.getPrice());

        Technician technician = technicianRepo.findById(testDTO.getTechnicianId()).orElseThrow();


        test.setTechnician(technician);
        return testRepo.save(test).getDTO();
    }
}
