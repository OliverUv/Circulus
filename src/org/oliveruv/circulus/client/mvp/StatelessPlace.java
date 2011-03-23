package org.oliveruv.circulus.client.mvp;

import org.oliveruv.circulus.client.news.NewsPlace;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class StatelessPlace extends Place {
	public static class Tokenizer implements PlaceTokenizer<StatelessPlace> {
		@Override
		public String getToken(StatelessPlace place) {
			return null;
		}

		@Override
		public StatelessPlace getPlace(String token) {
			return null;
		}
	}
}
