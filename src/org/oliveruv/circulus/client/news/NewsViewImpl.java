package org.oliveruv.circulus.client.news;

import org.oliveruv.circulus.client.resources.BundledResources;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.inject.Inject;

public class NewsViewImpl extends Composite implements NewsView {

	private Presenter newsActivity;
	private BundledResources res;
	private FlowPanel panel = new FlowPanel();
	private Label newsTitle;
	
	private final String title = "Only the shiniest news.";
	
	@Override
	public void setPresenter(Presenter presenter) {
		newsActivity = presenter;
		panel.clear();
		
		newsTitle = new Label(title);
		newsTitle.setStyleName(res.css().contentTitle());
		panel.add(newsTitle);
		
		panel.add(newsActivity.getNews());
		if(newsActivity.hasNextPage())
			panel.add(newsActivity.getNextPageLink());
	}

	@Inject
	public NewsViewImpl(BundledResources res) {
		super();
		this.res = res;
		panel.setStyleName(res.css().contentPane());
		initWidget(panel);
	}
	
	public void setTitle(String title) {
		newsTitle.setText(title);
	}
	
	public void resetTitle() {
		newsTitle.setText(title);
	}
}
