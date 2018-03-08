package com.project.print.paperestimate.service;

import com.project.print.paperestimate.model.PrintTask;

import java.math.BigDecimal;

public class A4CostEstimationServiceImpl implements CostEstimateService {

    private static final BigDecimal COLOR_SINGLE_SIDE = BigDecimal.valueOf(.25);
    private static final BigDecimal COLOR_DOUBLE_SIDE = BigDecimal.valueOf(.20);
    private static final BigDecimal BW_SINGLE_SIDE = BigDecimal.valueOf(.15);
    private static final BigDecimal BW_DOUBLE_SIDE = BigDecimal.valueOf(.10);

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
