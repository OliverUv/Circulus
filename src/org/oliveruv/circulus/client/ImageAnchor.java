package org.oliveruv.circulus.client;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Image;

public class ImageAnchor extends Anchor {
	public ImageAnchor(Image image, String style) {
		setResource(image, style);
    }

    public void setResource(Image image, String style) { 
    	image.setStyleName(style); 
        DOM.insertBefore(getElement(), image.getElement(), DOM 
                .getFirstChild(getElement())); 
    } 
}
