package org.oliveruv.circulus.client.welcome;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;

public class WelcomeViewImpl extends Composite implements WelcomeView {

	private Presenter liveActivity;
	private FlowPanel panel = new FlowPanel();
	
	@Override
	public void setPresenter(Presenter presenter) {
		liveActivity = presenter;
		panel.add(liveActivity.getWelcome());
		panel.add(liveActivity.getNews());
	}

	public WelcomeViewImpl() {
		super();
		initWidget(panel);
	}
}
