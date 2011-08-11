package org.oliveruv.circulus.client.media;

import java.util.HashMap;

import org.oliveruv.circulus.client.ContentProvider;
import org.oliveruv.circulus.shared.Ukuria;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class MediaActivity extends AbstractActivity  implements MediaView.Presenter {

	MediaView view;
	
	private final ContentProvider contentProvider;
	public String currentUkuria;
	
	@Inject
	public MediaActivity(MediaView view, ContentProvider contentProvider) {
		super();
		this.view = view;
		this.contentProvider = contentProvider;
		currentUkuria = "";
	}
	
	@Override
	public String getCurrentUkuria() {
		return currentUkuria;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view.setPresenter(this);
		panel.setWidget(view.asWidget());
	}

	@Override
	public void setView(MediaView view) {
		this.view = view;
	}

	public void initialize(MediaPlace place) {
		currentUkuria = place.getUkuria();
	}

	@Override
	public HashMap<String, Ukuria> getUkuria() {
		return contentProvider.getUkuria();
	}
}
