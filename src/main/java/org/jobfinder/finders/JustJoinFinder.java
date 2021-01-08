package org.jobfinder.finders;


import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.helper.SearchArguments;
import org.jobfinder.Finder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Getter
@Setter
@NoArgsConstructor

public class JustJoinFinder implements Finder {

    private static final String JUSTJOIN_URL = "https://justjoin.it/%s/%s/%s";
    private static final Logger logger = LoggerFactory.getLogger(JustJoinFinder.class);
    private SearchArguments searchArguments = SearchArguments.getInstance();

    private String formatUrl(){
        return String.format(JUSTJOIN_URL, searchArguments.getCity(),
                searchArguments.getTechnology(), searchArguments.getLevel());
    }


    @Override
    public void getAllJobsInformation() {
        String justJoinURL = formatUrl();

        try {
            WebClient webClient = new WebClient(BrowserVersion.CHROME);
            webClient.getOptions().setJavaScriptEnabled(true);
            webClient.getOptions().setThrowExceptionOnScriptError(false);
            webClient.waitForBackgroundJavaScriptStartingBefore(5000);
            HtmlPage page = webClient.getPage(justJoinURL);

            webClient.setStatusHandler(
               (page1, s) ->
                    logger.info(String.valueOf(page1.getWebResponse().getStatusCode()))

            );

            Document document = Jsoup.parse(page.asXml());


            Elements jobComponents = document.select("a.css-18rtd1e");

//            jobComponents.forEach(System.out::println);

        } catch (Exception e) {
            logger.error("Error while connecting to the url", e.fillInStackTrace());
        }

    }
}
