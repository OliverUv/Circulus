package org.oliveruv.circulus.client.news;

import org.oliveruv.circulus.client.Constants;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class NewsPlace extends Place {
	
	private int currentPage = 0;

	public NewsPlace(int page) {
		this.currentPage = page;
	}
	
	public NewsPlace() {
		this.currentPage = 0;
	}
	
	public int getCurrentPage() { return currentPage; }
	
	@Prefix(Constants.newsPlaceName)
	public static class Tokenizer implements PlaceTokenizer<NewsPlace> {
        @Override
        public String getToken(NewsPlace place) {
        	if(place.currentPage == 0) return "";
            return Integer.toString(place.currentPage);
        }

        @Override
        public NewsPlace getPlace(String token) {
        	int startPlace;
        	try {
        		startPlace = Integer.parseInt(token);
        	} catch (NumberFormatException e) {
        		startPlace = 0;
        	}
            return new NewsPlace(startPlace);
        }
    }
}
