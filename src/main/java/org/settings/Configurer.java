package org.settings;

import org.App;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Configurer {

    private static final Logger logger = LoggerFactory.getLogger(App.class);
    private static final String workFolderUrl = System.getProperty("user.home") + "\\Desktop\\praca";

    public static void initDirectory() {

        try {
            Files.createDirectory(Paths.get(workFolderUrl));
        } catch (Exception e) {
            logger.error(e.toString());
        }
    }

    public static String getWorkFolderUrl() {
        return workFolderUrl;
    }
}
