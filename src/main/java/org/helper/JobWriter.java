package org.helper;

import org.settings.Configurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JobWriter {

    private static final Logger logger = LoggerFactory.getLogger(JobWriter.class);

    public static void writeJobsToFile(List<String> jobs, String pageName) {
        logger.info(String.format("Writing jobs to file from %s", pageName));

        String workFolderUrl = Configurer.getWorkFolderUrl();

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(workFolderUrl + "//" + pageName + ".html"))) {

            for (String line : jobs) {
                writer.write(line);
                writer.write(System.lineSeparator());
                writer.newLine();
            }
        } catch (IOException e) {
            logger.error(e.toString());
        }

    }

    private JobWriter(){}
}
