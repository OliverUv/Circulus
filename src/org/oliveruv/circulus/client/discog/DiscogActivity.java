package org.oliveruv.circulus.client.discog;

import java.util.HashMap;

import org.oliveruv.circulus.client.ContentProvider;
import org.oliveruv.circulus.client.mvp.CirculusPlaceHistoryMapper;
import org.oliveruv.circulus.client.resources.BundledResources;
import org.oliveruv.circulus.shared.ReleaseItem;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

public class DiscogActivity extends AbstractActivity  implements DiscogView.Presenter {

	DiscogView view;
	private final ContentProvider contentProvider;
	private final BundledResources res;
	private final CirculusPlaceHistoryMapper mapper;
	public String currentAlbum;
	
	@Inject
	public DiscogActivity(DiscogView view, ContentProvider contentProvider, BundledResources resources, CirculusPlaceHistoryMapper mapper) {
		super();
		this.view = view;
		this.contentProvider = contentProvider;
		this.res = resources;
		this.mapper = mapper;
		currentAlbum = "";
	}
	
	public void initialize(DiscogPlace place) {
		currentAlbum = place.getAlbum();
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view.setPresenter(this);
		panel.setWidget(view.asWidget());
	}

	@Override
	public void setView(DiscogView view) {
		this.view = view;
	}

	@Override
	public HashMap<String, ReleaseItem> getDiscog() {
		return contentProvider.getDiscography();
	}
	
	public String getCurrentAlbum() {
		return currentAlbum;
	}
}
