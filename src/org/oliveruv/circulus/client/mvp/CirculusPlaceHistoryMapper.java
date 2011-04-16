package org.oliveruv.circulus.client.mvp;

import org.oliveruv.circulus.client.Injector;
import org.oliveruv.circulus.client.discog.DiscogPlace;
import org.oliveruv.circulus.client.bio.BioPlace;
import org.oliveruv.circulus.client.live.LivePlace;
import org.oliveruv.circulus.client.media.MediaPlace;
import org.oliveruv.circulus.client.news.NewsPlace;
import org.oliveruv.circulus.client.welcome.WelcomePlace;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({
	NewsPlace.Tokenizer.class,
	BioPlace.Tokenizer.class,
	DiscogPlace.Tokenizer.class,
	LivePlace.Tokenizer.class,
	MediaPlace.Tokenizer.class,
	WelcomePlace.Tokenizer.class })
public interface CirculusPlaceHistoryMapper extends PlaceHistoryMapper {
	
}
