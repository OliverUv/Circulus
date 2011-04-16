package org.oliveruv.circulus.client.live;

import org.oliveruv.circulus.client.ContentProvider;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

public class LiveActivity extends AbstractActivity  implements LiveView.Presenter {

	LiveView view;
	
	private final ContentProvider contentProvider;
	
	@Inject
	public LiveActivity(LiveView view, ContentProvider contentProvider) {
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
	public void setView(LiveView view) {
		this.view = view;
	}

	@Override
	public String getLiveInfo() {
		return "It's a live!";
	}
}
