package com.project.print.paperestimate.service;

import com.project.print.paperestimate.model.PrintTask;

import java.math.BigDecimal;

public class A4CostEstimationServiceImpl implements CostEstimateService{

    private BigDecimal COLOR_SINGLE_SIDE = new BigDecimal(.25);
    private BigDecimal COLOR_DOUBLE_SIDE = new BigDecimal(.10);
    private BigDecimal BW_SINGLE_SIDE = new BigDecimal(.15);
    private BigDecimal BW_DOUBLE_SIDE = new BigDecimal(.10);

    public BigDecimal getPrintTaskCost(PrintTask task) {

        return task.getDoubleSided() ? getPrintCostForDoubleSided(task) : printTaskForSingleSided(task);
    }

    private BigDecimal getPrintCostForDoubleSided(PrintTask task) {
        return task.getColorPagesCount().multiply(COLOR_DOUBLE_SIDE).add(
                (task.getTotalPagesCount().subtract(task.getColorPagesCount()).multiply(BW_DOUBLE_SIDE)));
    }

    private BigDecimal printTaskForSingleSided(PrintTask task) {
        return task.getColorPagesCount().multiply(COLOR_SINGLE_SIDE).add(
                (task.getTotalPagesCount().subtract(task.getColorPagesCount()).multiply(BW_SINGLE_SIDE)));
    }
}
