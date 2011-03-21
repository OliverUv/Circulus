package org.oliveruv.circulus.client;

import org.oliveruv.circulus.client.resources.BundledResources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.query.client.GQuery;
import com.google.gwt.query.client.css.CSS;
import com.google.gwt.query.client.css.Length;
import com.google.inject.Inject;

import com.google.gwt.query.client.Function;
import com.google.gwt.query.client.Selector;
import com.google.gwt.query.client.Selectors;
import static com.google.gwt.query.client.GQuery.*;
import static com.google.gwt.query.client.css.CSS.*;


class SizeManager implements ResizeHandler {
	BundledResources 	resources;
	double 				imageWidth;
	double 				imageHeight;
	double 				imageRatio;
	String 				imageTagId = "#bg";
	double				minimumSize = 700;
	
	@Inject
	SizeManager(QuerySelector querySelector, BundledResources resources){
		this.resources   = resources;
		this.imageWidth  = (double) resources.background().getWidth();
		this.imageHeight = (double) resources.background().getHeight();
		this.imageRatio  = this.imageHeight / this.imageWidth;
	}
	
	public void resizeImage(int screenWidth, int screenHeight) {
		resizeImage((double) screenWidth, (double) screenHeight);
	}
	public void resizeImage(double screenWidth, double screenHeight) {
		
		//Prevent image from being smaller than minimumSize
		//Also means we won't divide by zero if width or height == 0 
		if (screenWidth < minimumSize && screenHeight < minimumSize) {
			resizeImage(minimumSize, minimumSize);
			return;
		} else if (screenWidth < minimumSize) {
			resizeImage(minimumSize, screenHeight);
			return;
		} else if (screenHeight < minimumSize) {
			resizeImage(screenWidth, minimumSize);
			return;
		}
		
		double screenRatio = screenHeight / screenWidth;
		GQuery imageTag = $(imageTagId);
		
		if(screenRatio < imageRatio) {
			imageTag.height((int) screenHeight);
			imageTag.width((int) (screenHeight / imageRatio));
			//log("1: ", screenRatio, screenHeight, screenWidth);
		} else {
			imageTag.width((int) screenWidth);
			imageTag.height((int) (screenWidth * imageRatio));
			//log("2: ", screenRatio, screenHeight, screenWidth);
		}

		imageTag.css(CSS.LEFT.with(Length.px((screenWidth - imageTag.width())/2)));
		imageTag.css(CSS.TOP.with(Length.px((screenHeight - imageTag.height())/2)));
	}
	
	private void log(String branch, double screenRatio, double screenHeight, double screenWidth) {
		GWT.log("Branch: " + branch + "\n" +
				"Image h/w (" + imageHeight + "/" + imageWidth + ") = " + imageRatio +
				"\nScreen h/w (" + screenHeight + "/" + screenWidth + ") = " + screenRatio);
	}

	@Override
	public void onResize(ResizeEvent event) {
		resizeImage(event.getWidth(), event.getHeight());
	}
}