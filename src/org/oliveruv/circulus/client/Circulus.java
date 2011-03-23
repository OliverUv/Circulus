package org.oliveruv.circulus.client;

import org.oliveruv.circulus.client.news.NewsPlace;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.query.client.GQuery;
import com.google.gwt.query.client.Function;
import com.google.gwt.query.client.Selector;
import com.google.gwt.query.client.Selectors;
import static com.google.gwt.query.client.GQuery.*;
import static com.google.gwt.query.client.css.CSS.*;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Circulus implements EntryPoint {
	private final Injector injector = GWT.create(Injector.class);
	private SimplePanel shellWidget = new SimplePanel();
	private Place defaultStartPlace = new NewsPlace();

	public void onModuleLoad() {
		//Set up MVP
		PlaceController placeController = injector.getPlaceController();
		ActivityManager activityManager = injector.getActivityManager();
		activityManager.setDisplay(shellWidget);
		PlaceHistoryHandler phh = injector.getPlaceHistoryHandler();
		phh.register(placeController, injector.getEventBus(), defaultStartPlace);
		
		//Fix the size hooplas
		SizeManager resizeHandler = injector.getResizeHandler();
		com.google.gwt.user.client.Window.addResizeHandler(resizeHandler);
		
		addContentWrapper(Constants.resizeTagId);
		injector.getResources().css().ensureInjected();
		initializeImageSize(resizeHandler);
		
		//Launch app
		RootPanel.get(injector.getResources().css().contentPane()).add(shellWidget);
		phh.handleCurrentHistory();
	}
	
	private void initializeImageSize(SizeManager resizeHandler) {
		resizeHandler.resizeImage(Window.getClientWidth(), Window.getClientHeight());
	}

	private void addContentWrapper(String tagId) {
		//Add stretched image as background
		$("#"+tagId).append(
				"<img class=\"" +
				injector.getResources().css().backgroundImage() +
				"\" src=" + 
				injector.getResources().background().getURL() +
				"/>"
				);
		
		$("#"+tagId).append(
				"<div class=\"" +
				injector.getResources().css().contentPane() +
				"/>"
				);
	}
}
