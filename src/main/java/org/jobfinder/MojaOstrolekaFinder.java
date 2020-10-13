package org.jobfinder;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.settings.Configurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;



public class MojaOstrolekaFinder implements Finder {

    private static final String url = "https://ogloszenia.moja-ostroleka.pl/szukaj,praca,9,1.html";
    private static ArrayList<String> jobInfo = new ArrayList<>();
    private static final Logger logger = LoggerFactory.getLogger(MojaOstrolekaFinder.class);

    @Override
    public void getAllJobsInformation() {

        try {
            Document htmlDoc  = Jsoup.connect(modifyUrl(1)).get();
            int pagesCount = getPagesCount(htmlDoc);
            int linkCounter = 0;

        for(int i = 1; i <= pagesCount; i++) {

            htmlDoc = Jsoup.connect(modifyUrl(i)).get();

            Elements mainSection = htmlDoc.select("div.listing");
            Elements jobs = mainSection.select("div.row");


            for (Element job : jobs) {
                Elements a = job.getElementsByTag("a");
                if (a.size() > 0) {
                    linkCounter++;
                    jobInfo.add("<a style='font-size:25px;' href='" + a.get(0).attr("href") + "'>" + linkCounter + "  " + a.get(0).attr("title") + "</a>" + "<br>");
                }
            }

        }
        } catch (IOException e) {
            e.printStackTrace();
        }

        writeJobsToFile();

    }

    private static int getPagesCount(Document htmlDoc) {
        return htmlDoc.getElementsByClass("pagination").get(0).getElementsByTag("li").size() - 1;
    }


    private static String modifyUrl(int pageNumber) {
        return url.substring(0, url.lastIndexOf(",")) + "," + pageNumber + ".html";
    }

    private static void writeJobsToFile() {

        logger.info("Writing jobs to file");

        String workFolderUrl = Configurer.getWorkFolderUrl();

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(workFolderUrl + "//moja-ostroleka.html"));
            for(String line : jobInfo){
                writer.write(line);
                writer.write(System.lineSeparator());
                writer.newLine();

            }
            writer.close();

        } catch (IOException e) {
            logger.error(e.toString());
        }

    }




}
