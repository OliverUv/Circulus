package org.oliveruv.circulus.client.live;

import org.oliveruv.circulus.client.Constants;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class LivePlace extends Place {
	
	@Prefix(Constants.livePlaceName)
	public static class Tokenizer implements PlaceTokenizer<LivePlace> {
        @Override
        public String getToken(LivePlace place) {
            return "";
        }

        @Override
        public LivePlace getPlace(String token) {
            return new LivePlace();
        }
    }
}
