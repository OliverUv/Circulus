package org.oliveruv.circulus.client.discog;

import org.oliveruv.circulus.client.ContentProvider;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

public class DiscogActivity extends AbstractActivity  implements DiscogView.Presenter {

	DiscogView view;
	
	private final ContentProvider contentProvider;
	
	@Inject
	public DiscogActivity(DiscogView view, ContentProvider contentProvider) {
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
	public void setView(DiscogView view) {
		this.view = view;
	}

	@Override
	public String getDiscog() {
		return "Disco dancing time!";
	}
}
