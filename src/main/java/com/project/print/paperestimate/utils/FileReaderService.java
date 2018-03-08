package com.project.print.paperestimate.utils;

import com.project.print.paperestimate.model.PrintTask;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface FileReaderService {

    List<PrintTask> readFile(File file) throws IOException;
}
