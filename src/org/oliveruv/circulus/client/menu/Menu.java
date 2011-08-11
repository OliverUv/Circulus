package org.oliveruv.circulus.client.menu;

import org.oliveruv.circulus.client.Constants;
import org.oliveruv.circulus.client.ContentProvider;
import org.oliveruv.circulus.client.bio.BioPlace;
import org.oliveruv.circulus.client.discog.DiscogPlace;
import org.oliveruv.circulus.client.live.LivePlace;
import org.oliveruv.circulus.client.media.MediaPlace;
import org.oliveruv.circulus.client.mvp.CirculusPlaceHistoryMapper;
import org.oliveruv.circulus.client.news.NewsPlace;
import org.oliveruv.circulus.client.resources.BundledResources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Node;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceChangeEvent;
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

public class Menu extends Composite implements PlaceChangeEvent.Handler {
	interface MenuUiBinder extends UiBinder<Widget, Menu> {
	}

	private static MenuUiBinder uiBinder = GWT.create(MenuUiBinder.class);

	@UiField
	Hyperlink news;
	@UiField
	Hyperlink bio;
	@UiField
	Hyperlink discog;
	@UiField
	Hyperlink live;
	@UiField
	Hyperlink media;

	@UiField(provided = true)
	final BundledResources res;

	private final CirculusPlaceHistoryMapper mapper;
	private final EventBus eventBus;
	private final ContentProvider cp;

	@Inject
	public Menu(BundledResources resources, CirculusPlaceHistoryMapper mapper,
			EventBus eventBus, ContentProvider contentProvider) {
		this.res = resources;
		this.mapper = mapper;
		this.eventBus = eventBus;
		this.cp = contentProvider;
		initWidget(uiBinder.createAndBindUi(this));

		news.setTargetHistoryToken(mapper.getToken(new NewsPlace()));
		bio.setTargetHistoryToken(mapper.getToken(new BioPlace()));
		discog.setTargetHistoryToken(mapper.getToken(new DiscogPlace(cp.getMostRecentAlbumName())));
		live.setTargetHistoryToken(mapper.getToken(new LivePlace()));
		media.setTargetHistoryToken(mapper.getToken(new MediaPlace("")));

		// Register to history changed events
		eventBus.addHandler(PlaceChangeEvent.TYPE, this);
	}

	@Override
	public void onPlaceChange(PlaceChangeEvent event) {
		removeActivityIndicator();
		Place p = event.getNewPlace();
		if (p instanceof NewsPlace) {
			setActive(news);
		} else if (p instanceof BioPlace) {
			setActive(bio);
		} else if (p instanceof DiscogPlace) {
			setActive(discog);
		} else if (p instanceof LivePlace) {
			setActive(live);
		} else if (p instanceof MediaPlace) {
			setActive(media);
		}
	}

	private void setActive(Hyperlink link) {
		Element a = link.getElement().getFirstChildElement();
		a.addClassName(res.css().active());
	}
	
	private void removeActive(Hyperlink link) {
		Element a = link.getElement().getFirstChildElement();
		a.removeClassName(res.css().active());
	}

	private void removeActivityIndicator() {
		removeActive(news);
		removeActive(bio);
		removeActive(discog);
		removeActive(live);
		removeActive(media);
	}
}