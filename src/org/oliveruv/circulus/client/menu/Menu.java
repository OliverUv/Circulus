package org.oliveruv.circulus.client.menu;

import org.oliveruv.circulus.client.Constants;
import org.oliveruv.circulus.client.news.NewsPlace;
import org.oliveruv.circulus.client.resources.BundledResources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.MenuItemSeparator;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class Menu extends Composite {
	interface MenuUiBinder extends UiBinder<Widget, Menu> {}
	private static MenuUiBinder uiBinder = GWT.create(MenuUiBinder.class);
	
	@UiField Hyperlink news;
	@UiField Hyperlink bio;
	@UiField Hyperlink discog;
	@UiField Hyperlink live;
	@UiField Hyperlink media;
	
	@UiField(provided = true)
	final BundledResources res;
	
	NewsPlace newsPlace;
	
	@Inject
	public Menu(BundledResources resources, NewsPlace newsPlace) {
		this.res = resources;
		this.newsPlace = newsPlace;
		initWidget(uiBinder.createAndBindUi(this));
		news.setTargetHistoryToken(Constants.newsPlaceName);
		bio.setTargetHistoryToken(Constants.bioPlaceName);
	}
}