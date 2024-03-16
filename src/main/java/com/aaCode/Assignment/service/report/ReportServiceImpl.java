package com.aaCode.Assignment.service.report;

import com.aaCode.Assignment.dto.ReportDTO;
import com.aaCode.Assignment.dto.TechnicianDTO;
import com.aaCode.Assignment.entity.Report;
import com.aaCode.Assignment.entity.Technician;
import com.aaCode.Assignment.repository.ReportRepo;
import com.aaCode.Assignment.repository.TechnicianRepo;
import com.aaCode.Assignment.service.appointment.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    private final ReportRepo reportRepo;

    @Autowired
    public ReportServiceImpl(ReportRepo reportRepo) {
        this.reportRepo = reportRepo;
    }

    public Report createReport(ReportDTO reportDTO){
        Report report = new Report();

        report.setPatient_name(reportDTO.getPatient_name());
        report.setTest_name(reportDTO.getTest_name());
        report.setDoctor_name(reportDTO.getDoctor_name());
        report.setResult(reportDTO.getResult());
        report.setDate(reportDTO.getDate());

        return reportRepo.save(report);
    }

    public List<Report> getAllReport(){
        return reportRepo.findAll();
    }

}
