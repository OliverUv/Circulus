package org.oliveruv.circulus.client.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;
import com.google.gwt.resources.client.ImageResource.RepeatStyle;

public interface BundledResources extends ClientBundle {
	public interface CirculusCssResource extends CssResource {
		//String contentPane();
	}

	@Source ("final-background-no-title.jpg")
	public ImageResource background();
	
	@Source ("fbbutton.png")
	public ImageResource facebookButton();
	
	@Source ("lastfmbutton.png")
	public ImageResource lastfmButton();
	
	@Source ("wikibutton.png")
	public ImageResource wikipediaButton();
	
	@Source ("final-title.png")
	public ImageResource title();

	@Source ("circulus.css")
	public CirculusCssResource css();
}
