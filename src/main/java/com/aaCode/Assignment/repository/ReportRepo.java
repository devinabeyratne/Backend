package com.aaCode.Assignment.repository;

import com.aaCode.Assignment.entity.Report;
import com.aaCode.Assignment.entity.Technician;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepo extends JpaRepository<Report, Long> {
}
