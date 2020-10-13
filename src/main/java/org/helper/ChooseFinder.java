package org.helper;

import org.jobfinder.Finder;

public class ChooseFinder {

    private Finder finder;

    public ChooseFinder(Finder finder) {
        this.finder = finder;
    }

    public void findJob(){
        finder.getAllJobsInformation();
    }
}
