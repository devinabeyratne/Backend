package com.aaCode.Assignment.service.report;

import com.aaCode.Assignment.dto.ReportDTO;
import com.aaCode.Assignment.entity.Report;

import java.util.List;

public interface ReportService {

    Report createReport(ReportDTO reportDTO);

    List<Report> getAllReport();
}
