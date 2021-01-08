package org.jobfinder;

import org.jobfinder.finders.JustJoinFinder;
import org.jobfinder.finders.MojaOstrolekaFinder;
import org.jobfinder.finders.NoFluffFinder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class FinderFactory {

    private static final Logger logger = LoggerFactory.getLogger(FinderFactory.class);

    private Finder finder;

    public Finder chooseFinder(String finderName){
        switch (finderName) {
            case "-nofluff":
                this.finder = new NoFluffFinder();
                break;
            case "-justjoin":
                this.finder = new JustJoinFinder();
                break;
            case "-moja":
                this.finder = new MojaOstrolekaFinder();
                break;
            default:
                logger.info(String.format("Could not find suitable Finder for %s name.", finderName));
                break;
        }
        return finder;
    }

}
