package com.aaCode.Assignment.controller;

import com.aaCode.Assignment.dto.ReportDTO;
import com.aaCode.Assignment.dto.TechnicianDTO;
import com.aaCode.Assignment.entity.Report;
import com.aaCode.Assignment.entity.Technician;
import com.aaCode.Assignment.service.report.ReportService;
import com.aaCode.Assignment.service.technician.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/report")
@CrossOrigin("*")
public class ReportController {

    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping(path = "/createReport")
    public ResponseEntity<Report> addReport(@RequestBody ReportDTO reportDTO){
        Report report = reportService.createReport(reportDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(report);

    }

    @GetMapping(path = "/getAllReport")
    public ResponseEntity<List<Report>> getAllReports(){
        return ResponseEntity.ok(reportService.getAllReport());
    }
}
