package org;


import org.helper.ChooseFinder;
import org.jobfinder.MojaOstrolekaFinder;

public class App {

    public static void main( String[] args ) {
        new ChooseFinder(new MojaOstrolekaFinder()).findJob();
    }
}
