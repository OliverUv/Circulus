package org.oliveruv.circulus.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
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
	private final CirculusInjector injector = GWT.create(CirculusInjector.class);
	private final String sizeSwitcherId = "bg";

	public void onModuleLoad() {
		SizeManager resizeHandler = injector.getResizeHandler();
		com.google.gwt.user.client.Window.addResizeHandler(resizeHandler);
		
		addBackgroundImage(Constants.resizeTagId);
		initializeImageSize(resizeHandler);
		
		injector.getResources().css().ensureInjected();
	}
	
	private void initializeImageSize(SizeManager resizeHandler) {
		resizeHandler.resizeImage(Window.getClientWidth(), Window.getClientHeight());
	}

	private void addBackgroundImage(String tagId) {
		$("body").append(
				"<image id=\"" + tagId + "\" src=" + 
				injector.getResources().background().getURL() +
				"/>"
				);
		
	}
}
