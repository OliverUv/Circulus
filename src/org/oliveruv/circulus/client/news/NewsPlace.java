package org.oliveruv.circulus.client.news;

import org.oliveruv.circulus.client.Constants;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class NewsPlace extends Place {
	
	@Prefix(Constants.newsPlaceName)
	public static class Tokenizer implements PlaceTokenizer<NewsPlace> {
        @Override
        public String getToken(NewsPlace place) {
            return null;
        }

        @Override
        public NewsPlace getPlace(String token) {
            return new NewsPlace();
        }
    }
}
