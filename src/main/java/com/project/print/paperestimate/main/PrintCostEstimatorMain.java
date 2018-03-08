package com.project.print.paperestimate.main;

import com.project.print.paperestimate.controller.CostEstimateController;
import com.project.print.paperestimate.model.PrintTask;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;

public class PrintCostEstimatorMain {

    public static void main(String s[]) {

        CostEstimateController controller = new CostEstimateController();
        List<PrintTask> tasks = controller.getAllPrintTask(new File(s[0]));
        BigDecimal totalCost = BigDecimal.ZERO;
        for(PrintTask task : tasks) {
            BigDecimal taskCost = controller.getPrintTaskCost(task);
            System.out.println(task.toString() +"  Costs   "+ taskCost);
            totalCost = totalCost.add(taskCost);
        }
        System.out.println(" the Total Cost to Print :"+totalCost);
    }
}
