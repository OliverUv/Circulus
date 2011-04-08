package org.oliveruv.circulus.client.news;

import org.oliveruv.circulus.client.ContentProvider;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

public class NewsActivity extends AbstractActivity  implements NewsView.Presenter {

	NewsView view;
	
	private final ContentProvider contentProvider;
	
	@Inject
	public NewsActivity(NewsView view, ContentProvider contentProvider) {
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
	public void setView(NewsView view) {
		this.view = view;
	}

	@Override
	public String getNews() {
		return "Constant news, constant change.";
	}
}
