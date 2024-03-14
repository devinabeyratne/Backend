package com.aaCode.Assignment.repository;

import com.aaCode.Assignment.entity.Technician;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnicianRepo extends JpaRepository<Technician, Long> {
}
