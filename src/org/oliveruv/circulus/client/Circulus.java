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

import static com.google.gwt.query.client.GQuery.*;
import static com.google.gwt.query.client.css.CSS.*;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Circulus implements EntryPoint {
	private final Injector injector = GWT.create(Injector.class);
	private SimplePanel contentContainer = new SimplePanel();

	public void onModuleLoad() {
		//Set up MVP
		PlaceHistoryHandler phh = injector.getPlaceHistoryHandler();
		
		ActivityManager contentActivityManager = injector.getActivityManager();
		contentActivityManager.setDisplay(contentContainer);
		
		//Size hooplas
		SizeManager resizeHandler = injector.getResizeHandler();
		com.google.gwt.user.client.Window.addResizeHandler(resizeHandler);
		
		addStaticContent();
		injector.getResources().css().ensureInjected();
		initializeImageSize(resizeHandler);
		
		//Launch app
		RootPanel.get(Constants.menuPaneId).add(injector.getMenu());
		RootPanel.get(Constants.contentPaneId).add(contentContainer);
		phh.handleCurrentHistory();
	}
	
	private void initializeImageSize(SizeManager resizeHandler) {
		resizeHandler.resizeImage(Window.getClientWidth(), Window.getClientHeight());
	}

	private void addStaticContent() {
		//Add stretched image as background
		$("#"+ Constants.resizeTagId).append(
				"<img class=\"" +
				injector.getResources().css().backgroundImage() +
				"\" src=\"" + 
				injector.getResources().background().getURL() +
				"\"/>"
				);
		
		//Add menu pane
		$("#"+ Constants.resizeTagId).append(
				"<div class=\"" +
				injector.getResources().css().menuPane() +
				"\" id=\"" + 
				Constants.menuPaneId +
				"\"/>"
				);
		
		//Add content pane
		$("#"+ Constants.resizeTagId).append(
				"<div class=\"" +
				injector.getResources().css().contentPane() +
				"\" id=\"" + 
				Constants.contentPaneId +
				"\"/>"
				);
		
		//Add credits url
		$("#"+ Constants.resizeTagId).append(
				"<div class=\"" +
				injector.getResources().css().pixies() +
				"\"/><a href=\"http://www.github.com/OliverUv\">Powered by Pixies</a>"
				);
		
		//Add copyright url
		$("#"+ Constants.resizeTagId).append(
				"<div class=\"" +
				injector.getResources().css().copyright() +
				"\"/><a href=\"http://www.github.com/OliverUv/Circulus/blob/master/COPYRIGHT\">Copyrights etc, don't be a dick.</a>"
				);
		
		//Add external image links
		for (Anchor link : createImageLinks()) {
			RootPanel.get(Constants.contentPaneId).add(link);
		}
	}

	private List<Anchor> createImageLinks() {
		List<Anchor> imageLinks = new ArrayList<Anchor>();
		
		imageLinks.add(
				createImageLink(
						injector.getResources().title(),
						injector.getResources().css().title(),
						"Circulus", false,
						"http://www.circulus.org"
				));
		
		imageLinks.add(
				createImageLink(
						injector.getResources().wikiImage(),
						injector.getResources().css().wikiImage(),
						"Circulus on Wikipedia", true,
						"http://en.wikipedia.org/wiki/Circulus"
				));
		
		imageLinks.add(
				createImageLink(
						injector.getResources().lastfmImage(),
						injector.getResources().css().lastfmImage(),
						"Circulus on last.fm", true,
						"http://www.last.fm/music/Circulus"
				));
		
		imageLinks.add(
				createImageLink(
						injector.getResources().fbImage(),
						injector.getResources().css().fbImage(),
						"Circulus on Facebook", true,
						"http://www.facebook.com/pages/Circulus/109390525753763"
				));
		
		return imageLinks;
	}

	private Anchor createImageLink(ImageResource imageResource, String cssClassName,
			String altText, boolean altAsTitle, final String url) {
		
		Element img = DOM.createImg();
		img.setClassName(cssClassName);
		img.setAttribute("alt", altText);
		if (altAsTitle) {img.setAttribute("title", altText);}
		img.setAttribute("src", imageResource.getURL());

		Anchor link = new Anchor(img.getString(), true, url);
		return link;
	}
}
