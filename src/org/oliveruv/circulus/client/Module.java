/**
 * Copyright 2010 ArcBees Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package org.oliveruv.circulus.client;

import org.oliveruv.circulus.client.bio.BioActivity;
import org.oliveruv.circulus.client.bio.BioPlace;
import org.oliveruv.circulus.client.bio.BioView;
import org.oliveruv.circulus.client.bio.BioViewImpl;
import org.oliveruv.circulus.client.discog.DiscogActivity;
import org.oliveruv.circulus.client.discog.DiscogPlace;
import org.oliveruv.circulus.client.discog.DiscogView;
import org.oliveruv.circulus.client.discog.DiscogViewImpl;
import org.oliveruv.circulus.client.live.LiveActivity;
import org.oliveruv.circulus.client.live.LivePlace;
import org.oliveruv.circulus.client.live.LiveView;
import org.oliveruv.circulus.client.live.LiveViewImpl;
import org.oliveruv.circulus.client.media.MediaActivity;
import org.oliveruv.circulus.client.media.MediaPlace;
import org.oliveruv.circulus.client.media.MediaView;
import org.oliveruv.circulus.client.media.MediaViewImpl;
import org.oliveruv.circulus.client.menu.Menu;
import org.oliveruv.circulus.client.mvp.Content;
import org.oliveruv.circulus.client.mvp.ContentActivityMapper;
import org.oliveruv.circulus.client.mvp.CirculusPlaceHistoryMapper;
import org.oliveruv.circulus.client.mvp.DefaultPlace;
import org.oliveruv.circulus.client.news.NewsActivity;
import org.oliveruv.circulus.client.news.NewsPlace;
import org.oliveruv.circulus.client.news.NewsView;
import org.oliveruv.circulus.client.news.NewsViewImpl;
import org.oliveruv.circulus.client.resources.BundledResources;
import org.oliveruv.circulus.client.welcome.WelcomeActivity;
import org.oliveruv.circulus.client.welcome.WelcomePlace;
import org.oliveruv.circulus.client.welcome.WelcomeView;
import org.oliveruv.circulus.client.welcome.WelcomeViewImpl;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.inject.Provides;
import com.google.inject.Singleton;

public class Module extends AbstractGinModule {

	protected void configure() {
		// MVP infrastructure (see also @Providers below)
		bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
		//bind(PlaceController.class).in(Singleton.class);
		bind(PlaceHistoryMapper.class).to(CirculusPlaceHistoryMapper.class)
			.in(Singleton.class);
		bind(ActivityMapper.class).to(ContentActivityMapper.class).in(Singleton.class);
		//bind(ActivityManager.class).in(Singleton.class);
		
		// Resources + jQuery stuff
		bind(BundledResources.class).in(Singleton.class);
		bind(SizeManager.class).in(Singleton.class);
		bind(ContentProvider.class).in(Singleton.class);
		
		// Places, Views, etc
		bind(Menu.class).in(Singleton.class);
		
		bind(Place.class).annotatedWith(DefaultPlace.class).to(
				WelcomePlace.class).in(Singleton.class);
		
		bind(NewsPlace.class).in(Singleton.class);
		bind(NewsActivity.class);
		bind(NewsView.class).to(NewsViewImpl.class).in(Singleton.class);
		
		bind(BioPlace.class).in(Singleton.class);
		bind(BioActivity.class).in(Singleton.class);
		bind(BioView.class).to(BioViewImpl.class).in(Singleton.class);
		
		bind(DiscogPlace.class).in(Singleton.class);
		bind(DiscogActivity.class);
		bind(DiscogView.class).to(DiscogViewImpl.class).in(Singleton.class);

		bind(LivePlace.class).in(Singleton.class);
		bind(LiveActivity.class).in(Singleton.class);
		bind(LiveView.class).to(LiveViewImpl.class).in(Singleton.class);

		bind(MediaPlace.class).in(Singleton.class);
		bind(MediaActivity.class);
		bind(MediaView.class).to(MediaViewImpl.class).in(Singleton.class);

		bind(WelcomePlace.class).in(Singleton.class);
		bind(WelcomeActivity.class).in(Singleton.class);
		bind(WelcomeView.class).to(WelcomeViewImpl.class).in(Singleton.class);
	}
	
	@Singleton
	@Provides
	PlaceController providePlaceController(EventBus eventBus) {
		return new PlaceController(eventBus);
	}
	
	@Singleton
	@Provides
	ActivityManager provideActivityManager(ActivityMapper mapper,
			EventBus eventBus) {
		return new ActivityManager(mapper, eventBus);
	}
	
	@Singleton
	@Provides
	PlaceHistoryHandler providePlaceHistoryHandler(PlaceHistoryMapper mapper,
			PlaceController placeController, EventBus eventBus, @DefaultPlace
			Place defaultPlace) {
		PlaceHistoryHandler phh = new PlaceHistoryHandler(mapper);
		phh.register(placeController, eventBus, defaultPlace);
		return phh;
	}
}