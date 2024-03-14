package com.aaCode.Assignment.controller;

import com.aaCode.Assignment.dto.TechnicianDTO;
import com.aaCode.Assignment.dto.TestsDTO;
import com.aaCode.Assignment.entity.Technician;
import com.aaCode.Assignment.entity.Tests;
import com.aaCode.Assignment.service.technician.TechnicianService;
import com.aaCode.Assignment.service.tests.TestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/tests")
@CrossOrigin("*")
public class TestsController {

    private final TestsService testsService;

    @Autowired
    public TestsController(TestsService testsService) {
        this.testsService = testsService;
    }

    @PostMapping(path = "/createTests")
    public ResponseEntity<Tests> addTests(@RequestBody TestsDTO testsDTO){
        Tests tests = testsService.createTests(testsDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(tests);

    }

    @GetMapping(path = "/getAllTests")
    public ResponseEntity<List<Tests>> getAllTests(){
        return ResponseEntity.ok(testsService.getAllTests());
    }
}
