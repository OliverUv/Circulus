package org.oliveruv.circulus.client.mvp;

import org.oliveruv.circulus.client.Injector;
import org.oliveruv.circulus.client.news.NewsPlace;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.PlaceHistoryMapperWithFactory;
import com.google.gwt.place.shared.WithTokenizers;
import com.google.inject.Inject;

@WithTokenizers({ NewsPlace.Tokenizer.class })
public interface CirculusPlaceHistoryMapper extends PlaceHistoryMapper {
	
}
