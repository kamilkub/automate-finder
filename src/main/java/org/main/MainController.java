package org.main;


import org.settings.Configurer;


public class MainController {


    public void run(String[] args) {
        Configurer.initDirectory();
        runArguments(args);
    }

    private void runArguments(String [] args){
        new ArgsController().takeArguments(args);
    }


}
