package org.settings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Configurer {

    private static final Logger logger = LoggerFactory.getLogger(Configurer.class);
    private static final String WORK_FOLDER_PATH = System.getProperty("user.home") + "\\Desktop\\praca";


    private Configurer(){}

    public static void initDirectory() {
        try {
            Files.createDirectory(Paths.get(WORK_FOLDER_PATH));
        } catch (FileAlreadyExistsException ignored){
        } catch (Exception e) {
            logger.error(e.toString());
        }
    }

    public static String getWorkFolderUrl() {
        return WORK_FOLDER_PATH;

    }
}
