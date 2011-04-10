package org.oliveruv.circulus.client.bio;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;

public class BioViewImpl extends Composite implements BioView {

	private Presenter bioActivity;
	private Label label = new Label("No news yet!");
	
	@Override
	public void setPresenter(Presenter presenter) {
		bioActivity = presenter;
		label.setText(bioActivity.getBio());
	}

	public BioViewImpl() {
		super();
		SimplePanel panel = new SimplePanel();
		panel.add(label);
		initWidget(panel);
	}
}
