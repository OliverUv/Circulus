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

import org.oliveruv.circulus.client.mvp.CirculusActivityMapper;
import org.oliveruv.circulus.client.mvp.CirculusPlaceHistoryMapper;
import org.oliveruv.circulus.client.mvp.DefaultPlace;
import org.oliveruv.circulus.client.news.NewsPlace;
import org.oliveruv.circulus.client.resources.BundledResources;

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
		bind(ActivityMapper.class).to(CirculusActivityMapper.class).in(
				Singleton.class);

		// Default place to start at
		bind(Place.class).annotatedWith(DefaultPlace.class).to(NewsPlace.class);

		// Places, Views, etc
		//bind(NewsView.class).to(NewsWidget.class);

		// Resources + jQuery stuff
		bind(BundledResources.class).in(Singleton.class);
		bind(QuerySelector.class).in(Singleton.class);
		bind(SizeManager.class).in(Singleton.class);
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
			PlaceController controller, EventBus eventBus,
			@DefaultPlace Place defaultPlace) {
		PlaceHistoryHandler phh = new PlaceHistoryHandler(mapper);
		phh.register(controller, eventBus, defaultPlace);
		return phh;
	}
}