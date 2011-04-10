package org.oliveruv.circulus.client.bio;

import org.oliveruv.circulus.client.ContentProvider;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

public class BioActivity extends AbstractActivity  implements BioView.Presenter {

	BioView view;
	
	private final ContentProvider contentProvider;
	
	@Inject
	public BioActivity(BioView view, ContentProvider contentProvider) {
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
	public void setView(BioView view) {
		this.view = view;
	}

	@Override
	public String getBio() {
		return "Bio bots save the world!";
	}
}
