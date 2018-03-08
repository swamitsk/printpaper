package com.project.print.paperestimate.main;

import com.project.print.paperestimate.controller.CostEstimateController;
import com.project.print.paperestimate.model.PrintTask;
import com.project.print.paperestimate.service.A4CostEstimationServiceImpl;
import com.project.print.paperestimate.utils.CSVFileReader;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class PrintCostEstimatorMain {

    public static void main(String[] s) throws IOException {

        CostEstimateController controller =
                new CostEstimateController(new A4CostEstimationServiceImpl(), new CSVFileReader());
        List<PrintTask> tasks = controller.getAllPrintTask(new File("tasks.csv"));
        BigDecimal totalCost = BigDecimal.ZERO;
        for(PrintTask task : tasks) {
            BigDecimal taskCost = controller.getPrintTaskCost(task);
            System.out.println(printAsString(task) +"  Costs   "+ taskCost.setScale(2, BigDecimal.ROUND_FLOOR));
            totalCost = totalCost.add(taskCost);
        }
        System.out.println(" the Total Cost to Print :"+totalCost.setScale(2, BigDecimal.ROUND_FLOOR));
    }

    private static String printAsString(PrintTask task) {
        return " Page Type "+ task.getPageType() + " Color Page Count " + task.getColorPagesCount() + " Total Pages " +
                task.getTotalPagesCount() + " Is Double side" + task.getDoubleSided();
    }
}
