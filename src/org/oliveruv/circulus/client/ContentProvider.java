package org.oliveruv.circulus.client;

import java.sql.Date;
import java.util.ArrayList;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.ibm.icu.text.DateFormat;

import org.oliveruv.circulus.client.resources.BundledResources;
import org.oliveruv.circulus.shared.NewsItem;

public class ContentProvider {
	
	private final BundledResources res;
	private ArrayList<NewsItem> newsItems;

	@Inject
	public ContentProvider(BundledResources res) {
		this.res = res;
		newsItems = new ArrayList<NewsItem>();
		newsItems.add(new NewsItem(
				new Date(2011, 05, 12),
				"Oliver Uvman",
				"Hey! I made this site. Now it's up and running! Hope y'all like it!"));
	}
	
	/***
	 * 
	 * @param index 0 is the most recent item 
	 * @return 
	 */
	public Widget getNewsItem(int index) {
		
		return generateWidget(newsItems.get(index));
	}
	
	public Widget getLatestNews() {
		FlowPanel p = new FlowPanel();
		
		Label newsLabel = new Label("... the latest News:");
		newsLabel.setStyleName(res.css().latestNewsTitle());
		p.add(newsLabel);
		
		p.add(getNewsItem(0));
		
		return p;
	}
	
	public Widget getGreeting() {
		FlowPanel p = new FlowPanel();
		
		Label greetingTitle = new Label("Welcome to the land of Circulus.");
		greetingTitle.setStyleName(res.css().contentTitle());
		p.add(greetingTitle);
		
		Label greetingText = new Label("Here is a land where you will find minstralism, mushroom sound tracks and maidens locked away in castles in the left side of the brain.");
		greetingText.setStyleName(res.css().contentText());
		p.add(greetingText);
		
		Label greetingText21 = new Label("These present days are bountiful with access to many delightful realms.");
		greetingText21.setStyleName(res.css().contentText());
		p.add(greetingText21);
		
		Label greetingText2 = new Label("Early music, psychedelia and obscure releases by forgotten bands from the seventies all configure into the Circulus sound.");
		greetingText2.setStyleName(res.css().contentText());
		p.add(greetingText2);

		Label greetingText3 = new Label("Our aim is to bring you fresh vibrations as often as we can. Please download the free music we have for you.");
		greetingText3.setStyleName(res.css().contentText());
		p.add(greetingText3);
		
		return p;
	}
	
	private Widget generateWidget(NewsItem newsItem) {
		FlowPanel p = new FlowPanel();
		
		Label dateLabel = new Label(newsItem.getTimeString());
		dateLabel.setStyleName(res.css().contentText());
		dateLabel.addStyleName(res.css().newsDate()); 
		p.add(dateLabel);
		
		Label contentLabel = new Label(newsItem.getContents());
		contentLabel.setStyleName(res.css().contentText());
		contentLabel.addStyleName(res.css().newsContent());
		p.add(contentLabel);

		Label authorLabel = new Label("- " + newsItem.getAuthor());
		authorLabel.setStyleName(res.css().contentText());
		authorLabel.addStyleName(res.css().newsAuthor());
		p.add(authorLabel);
		
		return p;
	}
}
