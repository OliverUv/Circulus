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
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Image;

import static com.google.gwt.query.client.GQuery.*;
import static com.google.gwt.query.client.css.CSS.*;


class SizeManager implements ResizeHandler {
	BundledResources 	resources;
	double 				canvasImageWidth;
	double 				canvasImageHeight;
	double 				canvasImageRatio;
	String 				canvasImageTagId = "#" + Constants.resizeTagId;
	double				canvasMinimumSize = Constants.minimumSiteSize;
	
	@Inject
	SizeManager(BundledResources resources){
		this.resources   = resources;
		this.canvasImageWidth  = (double) resources.background().getWidth();
		this.canvasImageHeight = (double) resources.background().getHeight();
		this.canvasImageRatio  = this.canvasImageHeight / this.canvasImageWidth;
	}
	
	public void resizeCanvasImage(int screenWidth, int screenHeight) {
		resizeCanvasImage((double) screenWidth, (double) screenHeight);
	}
	
	public void resizeCanvasImage(double screenWidth, double screenHeight) {
		
		GQuery imageTag = $(canvasImageTagId);
		
		//Prevent image from being smaller than minimumSize
		//Also means we won't divide by zero if width or height == 0 
		if (screenWidth < canvasMinimumSize && screenHeight < canvasMinimumSize) {
			resizeCanvasImage(canvasMinimumSize, canvasMinimumSize);
			centerImage(imageTag, screenWidth, screenHeight);
			//make sure we center with the real widths and heights
			return;
		} else if (screenWidth < canvasMinimumSize) {
			resizeCanvasImage(canvasMinimumSize, screenHeight);
			centerImage(imageTag, screenWidth, screenHeight);
			return;
		} else if (screenHeight < canvasMinimumSize) {
			resizeCanvasImage(screenWidth, canvasMinimumSize);
			centerImage(imageTag, screenWidth, screenHeight);
			return;
		}	
		
		double screenRatio = screenHeight / screenWidth;
		
		if(screenRatio < canvasImageRatio) {
			imageTag.height((int) screenHeight);
			imageTag.width((int) (screenHeight / canvasImageRatio));
			imageTag.css(CSS.FONT_SIZE.with(Length.pct((100 * screenHeight) / canvasImageHeight)));
		} else {
			imageTag.width((int) screenWidth);
			imageTag.height((int) (screenWidth * canvasImageRatio));
			imageTag.css(CSS.FONT_SIZE.with(Length.pct((100 * screenWidth) / canvasImageWidth)));
		}

		centerImage(imageTag, screenWidth, screenHeight);
	}
	
	private void centerImage(GQuery imageTag, double screenWidth, double screenHeight) {
		imageTag.css(CSS.LEFT.with(Length.px((screenWidth - imageTag.width())/2)));
		imageTag.css(CSS.TOP.with(Length.px((screenHeight - imageTag.height())/2)));
	}
	
	private void log(String branch, double screenRatio, double screenHeight, double screenWidth) {
		GWT.log("Branch: " + branch + "\n" +
				"Image h/w (" + canvasImageHeight + "/" + canvasImageWidth + ") = " + canvasImageRatio +
				"\nScreen h/w (" + screenHeight + "/" + screenWidth + ") = " + screenRatio);
	}

	@Override
	public void onResize(ResizeEvent event) {
		resizeCanvasImage(event.getWidth(), event.getHeight());
	}
	
	// Takes a percentage size, to be interpreted as percent of the
	// containing image. Sets the image's css size in pixels, so that
	// it can still be used with relative positioning but still have
	// absolute positioning-style heights.
	public static void setImageHeight(Image image, double percentageHeight) {
		int imageHeight = image.getHeight();
		int imageWidth = image.getWidth();
		
		int screenHeight = Window.getClientHeight();
		int screenWidth = Window.getClientWidth();
		double screenRatio = screenHeight / screenWidth;
	}
}