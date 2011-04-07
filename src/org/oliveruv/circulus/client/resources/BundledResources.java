package org.oliveruv.circulus.client.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;
import com.google.gwt.resources.client.ImageResource.RepeatStyle;

public interface BundledResources extends ClientBundle {
	public interface CirculusCssResource extends CssResource {
		String contentPane();
		String backgroundImage();
		String menuPane();
		
		String miniflex();
		String active();
		String pixies();
		String copyright();
		
		String title();
		String wikiImage();
		String lastfmImage();
		String fbImage();
	}

	@Source ("newscan-bg.jpg")
	public ImageResource background();
	
	@Source ("fbbutton.png")
	public ImageResource fbImage();
	
	@Source ("lastfmbutton.png")
	public ImageResource lastfmImage();
	
	@Source ("wikibutton.png")
	public ImageResource wikiImage();
	
	@Source ("final-title.png")
	public ImageResource title();

	@Source ("circulus.css")
	public CirculusCssResource css();
	
	@Source ("Fertigo_PRO.otf")
	public DataResource fertigo();
}
