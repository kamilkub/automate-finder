package org.jobfinder.finders;


import org.helper.SearchArguments;
import org.jobfinder.Finder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class NoFluffFinder implements Finder {

    private static final Logger logger = LoggerFactory.getLogger(NoFluffFinder.class);

    private static final String NOFLUFF_URL = "https://nofluffjobs.com/pl/jobs/%s/%s?criteria=seniority%3D%s";

    private SearchArguments searchArguments = SearchArguments.getInstance();




    @Override
    public void getAllJobsInformation() {

           try {
               Document document = Jsoup.connect(modifyUrl()).get();

               Elements jobsPostings = document.getElementsByClass("posting-list-item");

               jobsPostings.forEach(element -> System.out.println(element.text()));

           } catch (Exception e) {
               logger.info("Unexpectable exception happened! Check the log file", e.fillInStackTrace());
           }


    }


    private String modifyUrl(){
        return String.format(NOFLUFF_URL, searchArguments.getTechnology(), searchArguments.getCity(), searchArguments.getLevel());
    }





}
