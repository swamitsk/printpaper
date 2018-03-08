package com.project.print.paperestimate.service;

import com.project.print.paperestimate.model.PrintTask;

import java.math.BigDecimal;

public interface CostEstimateService {

    BigDecimal getPrintTaskCost(PrintTask task);
}
