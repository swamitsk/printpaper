package com.project.print.paperestimate.service;

import com.project.print.paperestimate.model.PrintTask;
import com.project.print.paperestimate.utils.CSVFileReaderTest;
import static org.junit.Assert.*;

import java.math.BigDecimal;

public class A4CostEstimationServiceImplTest {

    @org.junit.Test
    public void getPrintTaskCost() throws Exception {
        BigDecimal expected = BigDecimal.valueOf(4.75);
        CostEstimateService costEstimateService = new A4CostEstimationServiceImpl();
        PrintTask task = CSVFileReaderTest.getPrintTask(BigDecimal.valueOf(25), BigDecimal.valueOf(10), false);
        BigDecimal cost = costEstimateService.getPrintTaskCost(task);
        assertEquals(expected, cost);
    }


}