package org.oliveruv.circulus.client.discog;

import java.util.HashMap;

import org.oliveruv.circulus.client.Constants;
import org.oliveruv.circulus.client.ContentProvider;
import org.oliveruv.circulus.shared.ReleaseItem;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;
import com.google.inject.Inject;

public class DiscogPlace extends Place {
	
	private String album;
	private ContentProvider cp;
	
	@Inject
	public DiscogPlace(ContentProvider contentProvider) {
		cp = contentProvider;
		album = cp.getMostRecentAlbumName();
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
