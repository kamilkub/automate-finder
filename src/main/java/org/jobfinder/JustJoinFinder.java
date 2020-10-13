package org.jobfinder;


import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;


public class JustJoinFinder {

        private static final String justJoinUrl = "https://justjoin.it/";
        private static final Logger logger = LoggerFactory.getLogger(JustJoinFinder.class);

        public static void getAllJobsInformation(String city, String level, String language) {
            String urlToConnect = justJoinUrl + city + File.separator + language + File.separator + level;

            try {
                WebClient webClient = new WebClient(BrowserVersion.CHROME);
                webClient.getOptions().setJavaScriptEnabled(true);
                webClient.getOptions().setThrowExceptionOnScriptError(false);
                webClient.waitForBackgroundJavaScriptStartingBefore(5000);
                HtmlPage page = webClient.getPage(urlToConnect);

                Document document = Jsoup.parse(page.asXml());


                Elements jobComponents = document.select("a.css-18rtd1e");

                jobComponents.forEach(System.out::println);

            } catch (Exception e) {
                logger.error("Error while connecting to the url", e.fillInStackTrace());
            }




        }



}
