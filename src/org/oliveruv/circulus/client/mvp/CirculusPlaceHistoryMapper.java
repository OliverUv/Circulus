package org.oliveruv.circulus.client.mvp;

import org.oliveruv.circulus.client.news.NewsPlace;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({ NewsPlace.Tokenizer.class })
public interface CirculusPlaceHistoryMapper extends PlaceHistoryMapper {

}
