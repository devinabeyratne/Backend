package com.aaCode.Assignment.service.tests;

import com.aaCode.Assignment.dto.TestsDTO;
import com.aaCode.Assignment.entity.Tests;

import java.util.List;

public interface TestsService {

    Tests createTests(TestsDTO testsDTO);

    List<Tests> getAllTests();
}
