package com.aaCode.Assignment.repository;

import com.aaCode.Assignment.entity.Technician;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TechnicianRepo extends JpaRepository<Technician, Long> {

    Optional<Technician> findById(Long id);
}
