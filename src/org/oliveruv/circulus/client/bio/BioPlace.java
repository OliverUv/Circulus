package org.oliveruv.circulus.client.bio;

import org.oliveruv.circulus.client.Constants;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class BioPlace extends Place {
	
	@Prefix(Constants.bioPlaceName)
	public static class Tokenizer implements PlaceTokenizer<BioPlace> {
        @Override
        public String getToken(BioPlace place) {
            return "";
        }

        @Override
        public BioPlace getPlace(String token) {
            return new BioPlace();
        }
    }
}
