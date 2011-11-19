package org.oliveruv.circulus.client.live;

import org.oliveruv.circulus.client.resources.BundledResources;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.inject.Inject;

public class LiveViewImpl extends Composite implements LiveView {

	private Presenter liveActivity;
	private BundledResources res;
	private FlowPanel panel = new FlowPanel();
	
	@Override
	public void setPresenter(Presenter presenter) {
		liveActivity = presenter;

		panel.clear();
		
		Label title = new Label("Performing for all, the Kingly.");
		title.setStyleName(res.css().contentTitle());
		panel.add(title);
		
		panel.add(liveActivity.getLiveActItems());
	}

	@Inject
	public LiveViewImpl(BundledResources resources) {
		super();
		this.res = resources;
		panel.setStyleName(res.css().contentPane());
		initWidget(panel);
	}
}
