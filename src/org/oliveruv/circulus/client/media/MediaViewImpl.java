package org.oliveruv.circulus.client.media;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;

public class MediaViewImpl extends Composite implements MediaView {

	private Presenter mediaActivity;
	private Label label = new Label("No news yet!");
	
	@Override
	public void setPresenter(Presenter presenter) {
		mediaActivity = presenter;
		label.setText(mediaActivity.getMediaInfo());
	}

	public MediaViewImpl() {
		super();
		SimplePanel panel = new SimplePanel();
		panel.add(label);
		initWidget(panel);
	}
}
