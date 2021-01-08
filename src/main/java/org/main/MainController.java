package org.main;


import org.settings.Configurer;


public class MainController {

    public void run(String[] args) {
        Configurer.initDirectory();
        new ArgsController().takeArguments(args);
    }

}
