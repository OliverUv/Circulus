package org.oliveruv.circulus.client.media;

import org.oliveruv.circulus.client.ContentProvider;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

public class MediaActivity extends AbstractActivity  implements MediaView.Presenter {

	MediaView view;
	
	private final ContentProvider contentProvider;
	
	@Inject
	public MediaActivity(MediaView view, ContentProvider contentProvider) {
		super();
		this.view = view;
		this.contentProvider = contentProvider;
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

	@Override
	public String getMediaInfo() {
		return "Let's head down to the mediaterranean oceans!";
	}
}
