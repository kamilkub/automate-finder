package org;


import org.jobfinder.MojaOstroleka;
import org.settings.Configurer;

public class App {

    public static void main( String[] args ) {
        Configurer.initDirectory();
        MojaOstroleka.getAllJobsInformation();
    }
}
