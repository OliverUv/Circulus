package org.oliveruv.circulus.client.discog;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;

public class DiscogViewImpl extends Composite implements DiscogView {

	private Presenter discogActivity;
	private Label label = new Label("No balbums yet!");
	
	@Override
	public void setPresenter(Presenter presenter) {
		discogActivity = presenter;
		label.setText(discogActivity.getDiscog());
	}

	public DiscogViewImpl() {
		super();
		SimplePanel panel = new SimplePanel();
		panel.add(label);
		initWidget(panel);
	}
}
