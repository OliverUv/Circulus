package org.oliveruv.circulus.client;

import static com.google.gwt.query.client.GQuery.$;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.dom.client.Element;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.UIObject;
import com.google.inject.Inject;


public class StaticContent {
	
	private final Injector injector;
	
	@Inject
	StaticContent(Injector injector){
		this.injector = injector;
	}
	
	public void addContent() {
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
				"<div id=\"" + 
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
				"\"/><a href=\"http://www.github.com/OliverUv/Circulus/blob/master/COPYRIGHT\">Copyrights etc, don't be a knave.</a>"
				);
		
		//Add title link image
		$("#"+ Constants.resizeTagId)
		.append(createTitleLink().getElement().getString());
		
		//Add external image links
		for (Anchor link : createImageLinks()) {
			$("#"+ Constants.resizeTagId)
				.append(link.getElement().getString());
		}
	}

	private Hyperlink createTitleLink() {
		Element img = DOM.createImg();
		img.setClassName(injector.getResources().css().title());
		img.setAttribute("alt", "Circulus");
		img.setAttribute("src", injector.getResources().title().getURL());

		Hyperlink link = new Hyperlink(img.getString(), true, "");
		return link;
	}

	private List<Anchor> createImageLinks() {
		List<Anchor> imageLinks = new ArrayList<Anchor>();
		
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
		
		imageLinks.add(
				createImageLink(
						injector.getResources().youtubeImage(),
						injector.getResources().css().youtubeImage(),
						"Circulus on YouTube", true,
						"http://www.youtube.com/results?search_query=circulus"
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
