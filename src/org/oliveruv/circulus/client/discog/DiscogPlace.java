package org.oliveruv.circulus.client.discog;

import org.oliveruv.circulus.client.Constants;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class DiscogPlace extends Place {
	
	private String album;
	
	public DiscogPlace() {
		album = "";
	}
	
	public DiscogPlace(String album) {
		this.album = album;
	}
	
	@Prefix(Constants.discogPlaceName)
	public static class Tokenizer implements PlaceTokenizer<DiscogPlace> {
        @Override
        public String getToken(DiscogPlace place) {
            return place.getAlbum();
        }

        @Override
        public DiscogPlace getPlace(String token) {
            return new DiscogPlace(token);
        }
    }

	public String getAlbum() {
		return album;
	}
}
