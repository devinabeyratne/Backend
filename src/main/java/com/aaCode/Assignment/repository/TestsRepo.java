package com.aaCode.Assignment.repository;

import com.aaCode.Assignment.entity.Technician;
import com.aaCode.Assignment.entity.Tests;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestsRepo extends JpaRepository<Tests, Long> {
}
