package org.oliveruv.circulus.client.welcome;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;

public class WelcomeViewImpl extends Composite implements WelcomeView {

	private Presenter liveActivity;
	private Label label = new Label("No news yet!");
	
	@Override
	public void setPresenter(Presenter presenter) {
		liveActivity = presenter;
		label.setText(liveActivity.getWelcome());
	}

	public WelcomeViewImpl() {
		super();
		SimplePanel panel = new SimplePanel();
		panel.add(label);
		initWidget(panel);
	}
}
