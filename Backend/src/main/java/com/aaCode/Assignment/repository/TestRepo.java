package com.aaCode.Assignment.repository;

import com.aaCode.Assignment.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepo extends JpaRepository<Test, Long>{
}
