package com.aaCode.Assignment.controller;

import com.aaCode.Assignment.dto.TechnicianDTO;
import com.aaCode.Assignment.dto.TestDTO;
import com.aaCode.Assignment.entity.Technician;
import com.aaCode.Assignment.entity.Test;
import com.aaCode.Assignment.service.technician.TechnicianService;
import com.aaCode.Assignment.service.test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "api/v1/test")
@CrossOrigin("*")
public class TestController {

    private final TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @PostMapping(path = "/createTest")
    public ResponseEntity<TestDTO> addTest(@RequestBody TestDTO testDTO) {
        TestDTO testDTO1 = testService.createTest(testDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(testDTO1);
    }

}