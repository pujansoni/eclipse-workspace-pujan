package com.crawler;

public class SpiderTest
{
    /**
     * This is our test. It creates a spider (which creates spider legs) and crawls the web.
     * 
     * @param args
     *            - not used
     *       
     * In this example we use jsoup to scrape the web to search for a particular word
     */
    public static void main(String[] args)
    {
        Spider spider = new Spider();
        spider.search("http://www.netinstructions.com//", "investment");
    }
}