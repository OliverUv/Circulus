package org.oliveruv.circulus.client.live;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;

public class LiveViewImpl extends Composite implements LiveView {

	private Presenter liveActivity;
	private Label label = new Label("No news yet!");
	
	@Override
	public void setPresenter(Presenter presenter) {
		liveActivity = presenter;
		label.setText(liveActivity.getLiveInfo());
	}

	public LiveViewImpl() {
		super();
		SimplePanel panel = new SimplePanel();
		panel.add(label);
		initWidget(panel);
	}
}
