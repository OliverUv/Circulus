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
		
		Label l = new Label("Circulus is currently in the creative process. Keep a lookout here to see us a live.");
		l.setStyleName(res.css().contentText());
		panel.add(l);
		
		l = new Label("Seek us on Ireland, by some festivus in October. More info soon-ish.");
		l.setStyleName(res.css().contentText());
		panel.add(l);
	}

	@Inject
	public LiveViewImpl(BundledResources resources) {
		super();
		this.res = resources;
		panel.setStyleName(res.css().contentPane());
		initWidget(panel);
	}
}
