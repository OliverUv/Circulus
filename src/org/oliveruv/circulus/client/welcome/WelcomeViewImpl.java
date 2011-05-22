package org.oliveruv.circulus.client.welcome;

import org.oliveruv.circulus.client.resources.BundledResources;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.inject.Inject;

public class WelcomeViewImpl extends Composite implements WelcomeView {

	private Presenter welcomeActivity;
	private BundledResources res;
	private FlowPanel panel = new FlowPanel();
	
	@Override
	public void setPresenter(Presenter presenter) {
		welcomeActivity = presenter;
		panel.clear();
		
		panel.add(welcomeActivity.getWelcome());
		
		Label latestNewsTitle = new Label("... the latest News:");
		latestNewsTitle.setStyleName(res.css().latestNewsTitle());
		panel.add(latestNewsTitle);
		
		panel.add(welcomeActivity.getNews());
	}

	@Inject
	public WelcomeViewImpl(BundledResources res) {
		super();
		this.res = res;
		panel.setStyleName(res.css().contentPane());
		initWidget(panel);
	}
}