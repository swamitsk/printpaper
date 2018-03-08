package com.project.print.paperestimate.utils;

import com.project.print.paperestimate.model.PrintTask;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class CSVFileReader implements FileReaderService {
    public List<PrintTask> readFile(File file) {

        return new ArrayList<PrintTask>();
    }
}
