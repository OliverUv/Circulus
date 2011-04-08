package org.oliveruv.circulus.client.news;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;

public class NewsViewImpl extends Composite implements NewsView {

	private Presenter newsActivity;
	private Label label = new Label("No news yet!");
	
	@Override
	public void setPresenter(Presenter presenter) {
		newsActivity = presenter;
		label.setText(newsActivity.getNews());
	}

	public NewsViewImpl() {
		super();
		SimplePanel panel = new SimplePanel();
		panel.add(label);
		initWidget(panel);
	}
}
