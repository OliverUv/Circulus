package org.oliveruv.circulus.client.media;

import org.oliveruv.circulus.client.resources.BundledResources;

import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.inject.Inject;

public class MediaViewImpl extends Composite implements MediaView {

	private Presenter mediaActivity;
	private BundledResources res;
	private FlowPanel panel = new FlowPanel();
	
	@Override
	public void setPresenter(Presenter presenter) {
		mediaActivity = presenter;
		panel.clear();
		
		Label title = new Label("And with eyes and ears open,");
		title.setStyleName(res.css().contentTitle());
		panel.add(title);
		
//		Label youtubeLabel = new Label("YouTube");
//		youtubeLabel.setStyleName(res.css().mediaItem());
//		Anchor youtube = new Anchor(youtubeLabel.getElement().getString(), true, "http://www.youtube.com/results?search_query=circulus");
//		panel.add(youtube);
		
		Anchor youtube = new Anchor("YouTube", "http://www.youtube.com/results?search_query=circulus");
		youtube.setStyleName(res.css().mediaItem());
		panel.add(youtube);
	}

	@Inject
	public MediaViewImpl(BundledResources resources) {
		super();
		this.res = resources;
		panel.setStyleName(res.css().contentPane());
		initWidget(panel);
	}
}
