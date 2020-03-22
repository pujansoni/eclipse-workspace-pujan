package jsoupaccess;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import jsoupweb.PageCollector;

public class WebPage {
	private Anchor anchor;
	private String webPageHash;
	private int anchorParseStatus;
	private int emailParseStatus;
	
	private Document document;
	
	
	public String getWebPageHash() {
		return webPageHash;
	}

	public int getAnchorParseStatus() {
		return anchorParseStatus;
	}

	public int getEmailParseStatus() {
		return emailParseStatus;
	}

	public Document getDocument() {
		return document;
	}

	public WebPage(Anchor anchor) {
		this.anchor = anchor;
	}
	
	private void loadDocumentFromWeb() {
		try {
			document = Jsoup.connect(anchor.getAnchorUrl()).get();
		} catch (IOException e) {
			Logger.getLogger(PageCollector.class.getName()).log(Level.SEVERE, null, e);
		}
	}
}
