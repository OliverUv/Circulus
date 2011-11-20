package org.oliveruv.circulus.client;

import java.util.ArrayList;
import java.util.List;

import org.oliveruv.circulus.client.menu.Menu;
import org.oliveruv.circulus.client.news.NewsPlace;
import org.oliveruv.circulus.client.news.NewsView;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.query.client.GQuery;
import com.google.gwt.query.client.Function;
import com.google.gwt.query.client.Selector;
import com.google.gwt.query.client.Selectors;
import com.google.gwt.resources.client.ImageResource;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.reveregroup.gwt.imagepreloader.ImageLoadEvent;
import com.reveregroup.gwt.imagepreloader.ImageLoadHandler;
import com.reveregroup.gwt.imagepreloader.ImagePreloader;

import static com.google.gwt.query.client.GQuery.*;
import static com.google.gwt.query.client.css.CSS.*;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Circulus implements EntryPoint {
	private final Injector injector = GWT.create(Injector.class);
	private SimplePanel contentContainer = new SimplePanel();

	public void onModuleLoad() {
		GWT.setUncaughtExceptionHandler(new LoggingExceptionHandler());
		Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
			@Override
			public void execute() {
				startApplication();
			}
		});
	}
	
	private void startApplication() {
		//Set up MVP
		PlaceHistoryHandler phh = injector.getPlaceHistoryHandler();
		
		ActivityManager contentActivityManager = injector.getActivityManager();
		contentActivityManager.setDisplay(contentContainer);
		
		//Size hooplas
		SizeManager resizeHandler = injector.getResizeHandler();
		com.google.gwt.user.client.Window.addResizeHandler(resizeHandler);
		
		injector.getStaticContent().addContent(); //Gives us some HTML
		injector.getResources().css().ensureInjected(); //Gives us some CSS
		initializeImageSize(resizeHandler);
		
		//Launch app
		RootPanel.get(Constants.menuPaneId).add(injector.getMenu());
		RootPanel.get(Constants.contentPaneId).add(contentContainer);
		phh.handleCurrentHistory();
		
		//Pre-load images
		ImageLoadHandler onAlbumsLoadedHandler = new OnAlbumImagesLoaded();
		
		ImagePreloader.load(injector.getResources().clocks().getSafeUri().asString(), onAlbumsLoadedHandler);
		ImagePreloader.load(injector.getResources().giantism().getSafeUri().asString(), onAlbumsLoadedHandler);
		ImagePreloader.load(injector.getResources().lick().getSafeUri().asString(), onAlbumsLoadedHandler);
		ImagePreloader.load(injector.getResources().thought().getSafeUri().asString(), onAlbumsLoadedHandler);
	}
	
	private class OnAlbumImagesLoaded implements ImageLoadHandler {
		int imagesLoaded = 0;
		
		@Override
		public void imageLoaded(ImageLoadEvent event) {
			imagesLoaded++;
			if (imagesLoaded < 4)
				return;
			
			// When all album images have loaded, load the hi-res background
			ImagePreloader.load(injector.getResources().backgroundHighResolution().getSafeUri().asString(), new ImageLoadHandler() {
				public void imageLoaded(ImageLoadEvent event) {
					// Switch the low-res background for the hi-res one
					injector.getStaticContent().switchToHiresBackground();
				}
			});
		}
	}
	
	private void initializeImageSize(SizeManager resizeHandler) {
		resizeHandler.resizeCanvasImage(Window.getClientWidth(), Window.getClientHeight());
	}

	
}
