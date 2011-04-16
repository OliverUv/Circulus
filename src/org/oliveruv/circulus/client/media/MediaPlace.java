package org.oliveruv.circulus.client.media;

import org.oliveruv.circulus.client.Constants;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class MediaPlace extends Place {
	
	@Prefix(Constants.mediaPlaceName)
	public static class Tokenizer implements PlaceTokenizer<MediaPlace> {
        @Override
        public String getToken(MediaPlace place) {
            return "";
        }

        @Override
        public MediaPlace getPlace(String token) {
            return new MediaPlace();
        }
    }
}
