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


public class JustJoinFinder implements Finder {

    private static final String justJoinUrl = "https://justjoin.it/";
    private static final Logger logger = LoggerFactory.getLogger(JustJoinFinder.class);
    private String city;
    private String level;
    private String language;

    public JustJoinFinder(String city, String level, String language) {
        this.city = city;
        this.level = level;
        this.language = language;
    }


    @Override
    public void getAllJobsInformation() {
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
