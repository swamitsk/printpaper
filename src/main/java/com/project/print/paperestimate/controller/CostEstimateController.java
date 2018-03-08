package com.project.print.paperestimate.controller;

import com.project.print.paperestimate.model.PrintTask;
import com.project.print.paperestimate.service.CostEstimateService;
import com.project.print.paperestimate.utils.FileReaderService;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class CostEstimateController {

    private CostEstimateService costEstimateService = null;
    private FileReaderService fileReaderService = null;


    public CostEstimateController(CostEstimateService costEstimateService, FileReaderService fileReaderService) {
        this.fileReaderService = fileReaderService;
        this.costEstimateService = costEstimateService;
    }

    public BigDecimal getPrintTaskCost(PrintTask task) {
        return costEstimateService.getPrintTaskCost(task);
    }

    public List<PrintTask> getAllPrintTask(File file) throws IOException {
        return fileReaderService.readFile(file);
    }
}
