package com.project.print.paperestimate.utils;

import com.project.print.paperestimate.model.PrintTask;
import org.junit.Test;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class CSVFileReaderTest {




    @Test
    public void readFile() throws Exception {

        ArrayList<PrintTask> printTasks = new ArrayList<PrintTask>();
        printTasks.add(getPrintTask(BigDecimal.valueOf(25), BigDecimal.valueOf(10), false));
        printTasks.add(getPrintTask(BigDecimal.valueOf(55), BigDecimal.valueOf(13), true));
        printTasks.add(getPrintTask(BigDecimal.valueOf(502), BigDecimal.valueOf(22), true));
        printTasks.add(getPrintTask(BigDecimal.valueOf(1), BigDecimal.valueOf(0), false));


        FileReaderService readerService = new CSVFileReader();
        ArrayList<PrintTask> arrayList = (ArrayList<PrintTask>)readerService.readFile(new File("tasks.csv"));
        assertEquals(printTasks.size(), arrayList.size());
        int i = 0;
        for(PrintTask task : printTasks) {
            assertEquals(task.toString(), printTasks.get(i).toString());
            i++;
        }
    }

    public static PrintTask getPrintTask(BigDecimal total, BigDecimal colorCount, Boolean isDoubleSided) {
        PrintTask task = new PrintTask();
        task.setTotalPagesCount(total);
        task.setColorPagesCount(colorCount);
        task.setDoubleSided(isDoubleSided);
        return task;
    }

}