package org.oliveruv.circulus.client.media;

import org.oliveruv.circulus.client.Constants;
import org.oliveruv.circulus.client.ContentProvider;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;
import com.google.inject.Inject;

public class MediaPlace extends Place {
	
	private String ukuria;
	private ContentProvider cp;
	
	@Inject
	public MediaPlace(ContentProvider contentProvider) {
		cp = contentProvider;
		ukuria = "";
	}
	
	public MediaPlace(String token) {
		ukuria = token;
	}
	
	public String getUkuria() {
		return ukuria;
	}
	
	@Prefix(Constants.mediaPlaceName)
	public static class Tokenizer implements PlaceTokenizer<MediaPlace> {
        @Override
        public String getToken(MediaPlace place) {
            return place.getUkuria();
        }

        @Override
        public MediaPlace getPlace(String token) {
            return new MediaPlace(token);
        }
    }
}
