/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockreporter;

import stockreporter.scrappers.YahooScraper;
import java.util.Date;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import org.junit.*;

/**
 *
 * @author ArvidsJE
 */
public class YahooScraperTest {
    
    public YahooScraperTest() {
    }

    /**
     * Test of scrapeAllSummaryData method, of class YahooScraper.
     */
    @Test
    public void testScrapeAllSummaryData() {
        System.out.println("scrapeAllSummaryData");
        YahooScraper instance = new YahooScraper();
        instance.scrapeAllSummaryData();
    }

    /**
     * Test of scrapeAllHistoricalData method, of class YahooScraper.
     */
    /*@Test
    public void testScrapeAllHistoricalData() {
        System.out.println("scrapeAllHistoricalData");
        YahooScraper instance = new YahooScraper();
        instance.scrapeAllHistoricalData();
    }*/
    
}
