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

import org.oliveruv.circulus.client.menu.Menu;
import org.oliveruv.circulus.client.mvp.CirculusPlaceHistoryMapper;
import org.oliveruv.circulus.client.news.NewsPlace;
import org.oliveruv.circulus.client.news.NewsActivity;
import org.oliveruv.circulus.client.resources.BundledResources;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.Widget;

@GinModules(Module.class)
public interface Injector extends Ginjector {
	//jQuery + Resources
	SizeManager getResizeHandler();

	BundledResources getResources();

	// MVP infrastructure
	EventBus getEventBus();

	PlaceController getPlaceController();

	ActivityManager getActivityManager();

	PlaceHistoryHandler getPlaceHistoryHandler();
	
	CirculusPlaceHistoryMapper getPlaceHistoryMapper();

	Menu getMenu();

	StaticContent getStaticContent();
}