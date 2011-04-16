package org.oliveruv.circulus.client.discog;

import org.oliveruv.circulus.client.Constants;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class DiscogPlace extends Place {
	
	@Prefix(Constants.discogPlaceName)
	public static class Tokenizer implements PlaceTokenizer<DiscogPlace> {
        @Override
        public String getToken(DiscogPlace place) {
            return "";
        }

        @Override
        public DiscogPlace getPlace(String token) {
            return new DiscogPlace();
        }
    }
}