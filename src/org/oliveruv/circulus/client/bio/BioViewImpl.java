package org.oliveruv.circulus.client.bio;

import org.oliveruv.circulus.client.Constants;
import org.oliveruv.circulus.client.resources.BundledResources;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.inject.Inject;

public class BioViewImpl extends Composite implements BioView {

	private Presenter bioActivity;
	private BundledResources res;
	private FlowPanel panel = new FlowPanel();
	
	@Override
	public void setPresenter(Presenter presenter) {
		bioActivity = presenter;
		panel.clear();
		
		Label title = new Label("Living biography.");
		title.setStyleName(res.css().contentTitle());
		panel.add(title);
		
		panel.add(bioActivity.getBio());
	}

	@Inject
	public BioViewImpl(BundledResources resources) {
		super();
		this.res = resources;
		panel.setStyleName(res.css().contentPane());
		initWidget(panel);
	}
}
