package com.project.print.paperestimate.controller;

import com.project.print.paperestimate.model.PrintTask;
import com.project.print.paperestimate.service.CostEstimateService;
import com.project.print.paperestimate.utils.FileReaderService;

import javax.inject.Inject;
import java.io.File;
import java.math.BigDecimal;
import java.util.List;

public class CostEstimateController {

    @Inject
    private FileReaderService fileReaderService;

    @Inject
    private CostEstimateService costEstimateService;

    public BigDecimal getPrintTaskCost(PrintTask task) {
        return costEstimateService.getPrintTaskCost(task);
    }

    public List<PrintTask> getAllPrintTask(File file) {
        return fileReaderService.readFile(file);
    }
}
