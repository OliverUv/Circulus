package org.oliveruv.circulus.client.mvp;

import org.oliveruv.circulus.client.bio.BioActivity;
import org.oliveruv.circulus.client.bio.BioPlace;
import org.oliveruv.circulus.client.discog.DiscogActivity;
import org.oliveruv.circulus.client.discog.DiscogPlace;
import org.oliveruv.circulus.client.live.LiveActivity;
import org.oliveruv.circulus.client.live.LivePlace;
import org.oliveruv.circulus.client.media.MediaActivity;
import org.oliveruv.circulus.client.media.MediaPlace;
import org.oliveruv.circulus.client.news.NewsActivity;
import org.oliveruv.circulus.client.news.NewsPlace;
import org.oliveruv.circulus.client.welcome.WelcomeActivity;
import org.oliveruv.circulus.client.welcome.WelcomePlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;
import com.google.inject.Provider;

/***
 * Maps Places to Activities. With stateless places, we don't
 * need to pass it the place. We can therefore use a singleton
 * activity instead of creating new ones all the time.
 * 
 * @author Oliver Uvman
 *
 */
public class ContentActivityMapper implements ActivityMapper {

	private final Provider<NewsActivity> newsActivityProvider;
	private final BioActivity bioActivity;
	private final Provider<DiscogActivity> discogActivityProvider;
	private final LiveActivity liveActivity;
	private final Provider<MediaActivity> mediaActivityProvider;
	private final WelcomeActivity welcomeActivity;
	
	@Override
	public Activity getActivity(Place place) {
		if (place instanceof NewsPlace) {
			NewsActivity na = newsActivityProvider.get();
			na.initialize((NewsPlace) place);
			return na;
			
		} else if (place instanceof BioPlace) {
			return bioActivity;
			
		} else if (place instanceof DiscogPlace) {
			DiscogActivity da = discogActivityProvider.get();
			da.initialize((DiscogPlace) place);
			return da;
			
		} else if (place instanceof LivePlace) {
			return liveActivity;
			
		} else if (place instanceof MediaPlace) {
			MediaActivity ma = mediaActivityProvider.get();
			ma.initialize((MediaPlace) place);
			return ma;
			
		} else if (place instanceof WelcomePlace) {
			return welcomeActivity;
			
		}
		return null;
	}

	@Inject
	public ContentActivityMapper(Provider<NewsActivity> newsActivityProvider,
			BioActivity bioActivity, Provider<DiscogActivity> discogActivityProvider,
			LiveActivity liveActivity, Provider<MediaActivity> mediaActivityProvider,
			WelcomeActivity welcomeActivity) {
		super();
		this.newsActivityProvider = newsActivityProvider;
		this.bioActivity = bioActivity;
		this.discogActivityProvider = discogActivityProvider;
		this.liveActivity = liveActivity;
		this.mediaActivityProvider = mediaActivityProvider;
		this.welcomeActivity = welcomeActivity;
	}
}
