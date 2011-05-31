package org.oliveruv.circulus.client;

import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

import org.oliveruv.circulus.client.resources.BundledResources;
import org.oliveruv.circulus.shared.NewsItem;
import org.oliveruv.circulus.shared.ReleaseItem;
import org.oliveruv.circulus.shared.ReleaseTrack;

public class ContentProvider {
	
	private final BundledResources res;
	private ArrayList<NewsItem> newsItems;
	private HashMap<String, ReleaseItem> releases;

	@Inject
	public ContentProvider(BundledResources res) {
		this.res = res;
		this.newsItems = getNews();
		this.releases = getReleases();
	}

	private HashMap<String, ReleaseItem> getReleases() {
		ReleaseItem giantism = new ReleaseItem("giantism", "Giantism", 1999, "Instant Farma", "EP", res.giantism());
		ArrayList<ReleaseTrack> giantismTracks = new ArrayList<ReleaseTrack>();
		giantismTracks.add(new ReleaseTrack(1, "Little Big Song", 5, 7));
		giantismTracks.add(new ReleaseTrack(2, "The True Lover's Farewell", 3, 54));
		giantismTracks.add(new ReleaseTrack(3, "My Lady Carey's Dompe", 2, 55));
		giantismTracks.add(new ReleaseTrack(4, "Everglade", 4, 39));
		giantismTracks.add(new ReleaseTrack(5, "Sombrero Fallout", 3, 40));
		giantismTracks.add(new ReleaseTrack(6, "All You People", 9, 14));
		giantism.setTracks(giantismTracks);
		
		ReleaseItem lick = new ReleaseItem("lick", "The Lick on the Tip of an Envelope Yet to Be Sent", 2005, "Rise Above Records", "Album", res.lick());
		ArrayList<ReleaseTrack> lickTracks = new ArrayList<ReleaseTrack>();
		lickTracks.add(new ReleaseTrack(1, "Miri It Is", 2, 36));
		lickTracks.add(new ReleaseTrack(2, "My Body Is Made of Sunlight", 3, 54));
		lickTracks.add(new ReleaseTrack(3, "The Scarecrow", 4, 56));
		lickTracks.add(new ReleaseTrack(4, "Orpheus", 3, 7));
		lickTracks.add(new ReleaseTrack(5, "We Are Long Lost", 5, 34));
		lickTracks.add(new ReleaseTrack(6, "Swallow", 3, 59));
		lickTracks.add(new ReleaseTrack(7, "The Aphid", 5, 19));
		lickTracks.add(new ReleaseTrack(8, "Candlelight", 3, 28));
		lickTracks.add(new ReleaseTrack(9, "Power to the Pixies", 6, 14));
		lick.setTracks(lickTracks);
		
		ArrayList<String> lickReviews = new ArrayList<String>();
		lickReviews.add("http://www.nme.com/reviews/circulus/7703");
		lickReviews.add("http://pitchfork.com/reviews/albums/1822-lick-on-the-tip-of-an-envelope-thats-yet-to-be-sent/");
		lick.setReviewUrls(lickReviews);
		
		
		ReleaseItem clocks = new ReleaseItem("clocks", "Clocks Are Like People", 2006, "Rise Above Records", "Album", res.clocks());
		ArrayList<ReleaseTrack> clocksTracks = new ArrayList<ReleaseTrack>();
		clocksTracks.add(new ReleaseTrack(1, "Dragon's Dance", 3, 20));
		clocksTracks.add(new ReleaseTrack(2, "Song of Our Despair", 4, 57));
		clocksTracks.add(new ReleaseTrack(3, "Willow Tree", 4, 56));
		clocksTracks.add(new ReleaseTrack(4, "Wherever She Goes", 4, 18));
		clocksTracks.add(new ReleaseTrack(5, "Velocity Races", 4, 3));
		clocksTracks.add(new ReleaseTrack(6, "To the Fields", 3, 22));
		clocksTracks.add(new ReleaseTrack(7, "Bourée", 3, 17));
		clocksTracks.add(new ReleaseTrack(8, "This Is the Way", 5, 34));
		clocksTracks.add(new ReleaseTrack(9, "Reality's a Fantasy", 8, 22));
		clocks.setTracks(clocksTracks);
		
		ArrayList<String> clocksReviews = new ArrayList<String>();
		clocksReviews.add("http://www.spiralearth.co.uk/reviews/clockpeople.asp");
		clocks.setReviewUrls(clocksReviews);
		
		ReleaseItem thought = new ReleaseItem("thought", "Thought Becomes Reality", 2009, "Mythical Cake", "Album", res.thought());
		ArrayList<ReleaseTrack> thoughtTracks = new ArrayList<ReleaseTrack>();
		thoughtTracks.add(new ReleaseTrack(1, "Transmuting Power", 4, 31));
		thoughtTracks.add(new ReleaseTrack(2, "Fortunate Ones", 2, 57));
		thoughtTracks.add(new ReleaseTrack(3, "Guide Our Way", 3, 34));
		thoughtTracks.add(new ReleaseTrack(4, "Michael's Garden", 3, 11));
		thoughtTracks.add(new ReleaseTrack(5, "Trotto", 2, 16));
		thoughtTracks.add(new ReleaseTrack(6, "Packingtons Pound", 3, 42));
		thoughtTracks.add(new ReleaseTrack(7, "Sumer Is Incumen In", 3, 15));
		thoughtTracks.add(new ReleaseTrack(8, "Tristans Laments", 4, 9));
		thoughtTracks.add(new ReleaseTrack(9, "Kalenda Maya", 4, 17));
		thoughtTracks.add(new ReleaseTrack(10, "Within You Is The Sun", 4, 30));
		
		HashMap<String, ReleaseItem> r = new HashMap<String, ReleaseItem>();
		r.put(thought.getKey(), thought);
		r.put(clocks.getKey(), clocks);
		r.put(lick.getKey(), lick);
		r.put(giantism.getKey(), giantism);
		return r;
	}

	private ArrayList<NewsItem> getNews() {
		ArrayList<NewsItem> items = new ArrayList<NewsItem>();
		items.add(new NewsItem(
				new Date(2011, 05, 12),
				"Oliver Uvman",
				"Hey! I made this site. Now it's up and running! Hope y'all like it!"));
		items.add(new NewsItem(
				new Date(2011, 05, 11),
				"Oliver Uvman",
				"This news thingie is just here to test some stuff out! Can you imagine? Me neither."));
		items.add(new NewsItem(
				new Date(2011, 05, 10),
				"Oliver Uvman",
				"The things I do! Writing on keyboards, making tiny lights turn different colours. When the colours are just right, I am convinced that I have helped other humans, and I am happy."));
		items.add(new NewsItem(
				new Date(2011, 05, 9),
				"Oliver Uvman",
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));
		return items;
	}
	
	/***
	 * Returns a number of news items starting from the most recent.
	 * @param index 0 is the most recent item
	 * @return A list of widgets, each containing a news item.
	 */
	public List<Widget> getNewsItems(int index, int numberOfItems) {
		if(index >= newsItems.size() || numberOfItems == 0) return new ArrayList<Widget>();
		
		int upperIndex = Math.min(index+numberOfItems, newsItems.size());
		List<NewsItem> selectedNewsItems = newsItems.subList(index, upperIndex);
		List<Widget> newsWidgets = new ArrayList<Widget>();
		
		for (NewsItem item : selectedNewsItems) {
			newsWidgets.add(generateWidget(item));
		}
		return newsWidgets;
	}
	
	public Widget getLatestNews() {
		List<Widget> items = getNewsItems(0, 1);
		if(items.isEmpty()) {
			return new Label("No news :(");
		} else {
			return items.get(0);
		}
	}
	
	public boolean hasNewsItem(int indexNumber) {
		return newsItems.size() > indexNumber;
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
	
	public Widget getBiography() {
		Label l = new Label("Sorry, no bio yet! Just read the wikipedia article for now. Top left-ish.");
		l.setStyleName(res.css().contentText());
		return l;
	}

	public HashMap<String, ReleaseItem> getDiscography() {
		return releases;
	}

	public String getMostRecentAlbumName() {
		String albumName = "thought";
		int age = 0;
		for (ReleaseItem i : releases.values()) {
			if (age == 0 || age > i.getYear()) {
				albumName = i.getKey();
				age = i.getYear();
			}
		}
		return albumName;
	}
}
