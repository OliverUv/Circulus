package org.oliveruv.circulus.client.mvp;

import org.oliveruv.circulus.client.Injector;
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

/***
 * Maps Places to Activities. With stateless places, we don't
 * need to pass it the place. We can therefore use a singleton
 * activity instead of creating new ones all the time.
 * 
 * @author Oliver Uvman
 *
 */
public class ContentActivityMapper implements ActivityMapper {

	private final NewsActivity newsActivity;
	private final BioActivity bioActivity;
	private final DiscogActivity discogActivity;
	private final LiveActivity liveActivity;
	private final MediaActivity mediaActivity;
	private final WelcomeActivity welcomeActivity;
	
	@Override
	public Activity getActivity(Place place) {
		if (place instanceof NewsPlace) {
			return newsActivity;
		} else if (place instanceof BioPlace) {
			return bioActivity;
		} else if (place instanceof DiscogPlace) {
			return discogActivity;
		} else if (place instanceof LivePlace) {
			return liveActivity;
		} else if (place instanceof MediaPlace) {
			return mediaActivity;
		} else if (place instanceof WelcomePlace) {
			return welcomeActivity;
		}
		return null;
	}

	@Inject
	public ContentActivityMapper(NewsActivity newsActivity,
			BioActivity bioActivity, DiscogActivity discogActivity,
			LiveActivity liveActivity, MediaActivity mediaActivity,
			WelcomeActivity welcomeActivity) {
		super();
		this.newsActivity = newsActivity;
		this.bioActivity = bioActivity;
		this.discogActivity = discogActivity;
		this.liveActivity = liveActivity;
		this.mediaActivity = mediaActivity;
		this.welcomeActivity = welcomeActivity;
	}
}
