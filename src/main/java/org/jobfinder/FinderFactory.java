package org.jobfinder;

import org.jobfinder.finders.JustJoinFinder;
import org.jobfinder.finders.MojaOstrolekaFinder;
import org.jobfinder.finders.NoFluffFinder;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


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


    public List<Finder> getAllFinders() {
        List<Finder> finderList = new ArrayList<>();
        Reflections reflections = new Reflections("org.jobfinder.finders");

        Set<Class<?>> typesAnnotatedWith = reflections.getTypesAnnotatedWith(FinderClass.class);


        for(Class clazz : typesAnnotatedWith){
            try {
                Constructor constructor = clazz.getDeclaredConstructor(null);
                Finder finderRef = (Finder) constructor.newInstance(null);
                finderList.add(finderRef);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return finderList;
    }

}
