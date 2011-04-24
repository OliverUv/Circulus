package org.oliveruv.circulus.client.welcome;

import org.oliveruv.circulus.client.ContentProvider;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class WelcomeActivity extends AbstractActivity  implements WelcomeView.Presenter {

	WelcomeView view;
	
	private final ContentProvider contentProvider;
	
	@Inject
	public WelcomeActivity(WelcomeView view, ContentProvider contentProvider) {
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
	public void setView(WelcomeView view) {
		this.view = view;
	}

	@Override
	public Widget getWelcome() {
		return contentProvider.getGreeting();
	}

	@Override
	public Widget getNews() {
		return contentProvider.getLatestNews();
	}
}
