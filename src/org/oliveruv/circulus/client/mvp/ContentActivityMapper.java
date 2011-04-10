package org.oliveruv.circulus.client.mvp;

import org.oliveruv.circulus.client.Injector;
import org.oliveruv.circulus.client.bio.BioPlace;
import org.oliveruv.circulus.client.news.NewsActivity;
import org.oliveruv.circulus.client.news.NewsPlace;

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
	private final NewsActivity bioActivity;
	
	@Override
	public Activity getActivity(Place place) {
		if (place instanceof NewsPlace) {
			return newsActivity;
		} else if (place instanceof BioPlace) {
			return bioActivity;
		}
		return null;
	}

	@Inject
	public ContentActivityMapper(NewsActivity newsActivity,
			NewsActivity bioActivity) {
		super();
		this.newsActivity = newsActivity;
		this.bioActivity = bioActivity;
	}

	
}
