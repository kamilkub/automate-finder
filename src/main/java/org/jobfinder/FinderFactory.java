package org.jobfinder;

import org.jobfinder.finders.JustJoinFinder;
import org.jobfinder.finders.MojaOstrolekaFinder;
import org.jobfinder.finders.NoFluffFinder;

public class FinderFactory {

    private Finder finder;

    public Finder chooseFinder(String finderName){
        if(finderName.equals("-nofluff")){
            this.finder = new NoFluffFinder();
        } else if(finderName.equals("-justjoin")){
            this.finder = new JustJoinFinder();
        } else if(finderName.equals("-moja")){
            this.finder = new MojaOstrolekaFinder();
        }
        return finder;
    }

}
