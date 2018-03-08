package com.project.print.paperestimate.utils;

import com.project.print.paperestimate.model.PrintTask;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;


public class CSVFileReader implements FileReaderService {


    public List<PrintTask> readFile(File file) throws IOException  {
        CSVParser parser = null;
        FileReader reader = null;
        List<PrintTask> tasks = new ArrayList<PrintTask>();

        try {
            CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');
            reader = new FileReader(file);
            parser = new CSVParser(reader, format);
            for (CSVRecord record : parser) {
                PrintTask printTask = getPrintTask(record);
                if (printTask != null) {
                    tasks.add(printTask);
                }
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (parser != null) {
                parser.close();
            }
        }

        return tasks;
    }

    private PrintTask getPrintTask(CSVRecord record) {
        PrintTask printTask = new PrintTask();
        try {
            printTask.setDoubleSided(Boolean.valueOf(record.get("Double-Sided")));
            printTask.setColorPagesCount(new BigDecimal(record.get("Color-Pages")));
            printTask.setTotalPagesCount(new BigDecimal(record.get("Total-Pages")));
        } catch (NumberFormatException exception) {
            return null;
        }
        return printTask;
    }
}
