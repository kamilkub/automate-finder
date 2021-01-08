package org.main;


import org.helper.ArgsInfo;
import org.helper.SearchArguments;
import org.jobfinder.Finder;
import org.jobfinder.FinderFactory;


public class ArgsController {

    private SearchArguments searchArguments = SearchArguments.getInstance();
    private FinderFactory finderFactory = new FinderFactory();

    public void takeArguments(String [] args){
        if(args.length == 0 || args[0].equals("help")){
            System.out.println(ArgsInfo.showHelpInfo());
        }

        chooseInitializer(args);

    }

    public void chooseInitializer(String [] args) {
       checkRestrictions(args);

       if(args[0].equals("-a")){

       } else {
           Finder finder = finderFactory.chooseFinder(args[0]);
           finder.getAllJobsInformation();
       }

    }


    private void checkRestrictions(String [] args){
        if(!args[1].trim().isEmpty()){
            searchArguments.setTechnology(args[1]);
        }
        if(!args[2].trim().isEmpty()){
            searchArguments.setCity(args[2]);
        }
        if(!args[3].trim().isEmpty()){
            searchArguments.setLevel(args[3]);
        }
    }

}
