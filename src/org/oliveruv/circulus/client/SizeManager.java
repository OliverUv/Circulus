package org.oliveruv.circulus.client;

import org.oliveruv.circulus.client.resources.BundledResources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.query.client.GQuery;
import com.google.gwt.query.client.css.CSS;
import com.google.gwt.query.client.css.Length;
import com.google.gwt.query.client.css.FontSizeProperty.FontSize;
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
	String 				imageTagId = "#" + Constants.resizeTagId;
	double				minimumSize = Constants.minimumSiteSize;
	
	@Inject
	SizeManager(BundledResources resources){
		this.resources   = resources;
		this.imageWidth  = (double) resources.background().getWidth();
		this.imageHeight = (double) resources.background().getHeight();
		this.imageRatio  = this.imageHeight / this.imageWidth;
	}
	
	public void resizeImage(int screenWidth, int screenHeight) {
		resizeImage((double) screenWidth, (double) screenHeight);
	}
	
	public void resizeImage(double screenWidth, double screenHeight) {
		
		GQuery imageTag = $(imageTagId);
		
		//Prevent image from being smaller than minimumSize
		//Also means we won't divide by zero if width or height == 0 
		if (screenWidth < minimumSize && screenHeight < minimumSize) {
			resizeImage(minimumSize, minimumSize);
			centerImage(imageTag, screenWidth, screenHeight);
			//make sure we center with the real widths and heights
			return;
		} else if (screenWidth < minimumSize) {
			resizeImage(minimumSize, screenHeight);
			centerImage(imageTag, screenWidth, screenHeight);
			return;
		} else if (screenHeight < minimumSize) {
			resizeImage(screenWidth, minimumSize);
			centerImage(imageTag, screenWidth, screenHeight);
			return;
		}	
		
		double screenRatio = screenHeight / screenWidth;
		
		if(screenRatio < imageRatio) {
			imageTag.height((int) screenHeight);
			imageTag.width((int) (screenHeight / imageRatio));
			imageTag.css(CSS.FONT_SIZE.with(Length.pct((100 * screenHeight) / imageHeight)));
			//log("1: ", screenRatio, screenHeight, screenWidth);
		} else {
			imageTag.width((int) screenWidth);
			imageTag.height((int) (screenWidth * imageRatio));
			imageTag.css(CSS.FONT_SIZE.with(Length.pct((100 * screenWidth) / imageWidth)));
			//log("2: ", screenRatio, screenHeight, screenWidth);
		}

		centerImage(imageTag, screenWidth, screenHeight);
	}
	
	private void centerImage(GQuery imageTag, double screenWidth, double screenHeight) {
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