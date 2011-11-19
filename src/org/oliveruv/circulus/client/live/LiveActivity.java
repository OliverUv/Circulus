package org.oliveruv.circulus.client.live;

import java.util.List;

import org.oliveruv.circulus.client.ContentProvider;
import org.oliveruv.circulus.client.resources.BundledResources;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class LiveActivity extends AbstractActivity  implements LiveView.Presenter {

	LiveView view;
	
	private final ContentProvider contentProvider;
	private final BundledResources res;
	
	@Inject
	public LiveActivity(LiveView view, ContentProvider contentProvider, BundledResources res) {
		super();
		this.view = view;
		this.contentProvider = contentProvider;
		this.res = res;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view.setPresenter(this);
		panel.setWidget(view.asWidget());
	}

	@Override
	public void setView(LiveView view) {
		this.view = view;
	}

	@Override
	public String getLiveInfo() {
		return "It's a live!";
	}

	@Override
	public Widget getLiveActItems() {
		List<Widget> liveActs = contentProvider.getLiveActs();
		
		if(liveActs.size() < 1)
			return generateNoLiveActsMessage();
		
		FlowPanel p = new FlowPanel();
		for(Widget item : liveActs) {
			p.add(item);
		}
		
		return p;
	}

	private Widget generateNoLiveActsMessage() {
		Label q = new Label("Regrettably, no live acts forthcoming.");
		q.setStyleName(res.css().contentText());
		q.addStyleName(res.css().newsQuestion());
		
		Label a = new Label("Soonish, we'll have some way to let you know by mail or such!");
		a.setStyleName(res.css().contentText());
		a.addStyleName(res.css().newsAnswer());
		
		FlowPanel p = new FlowPanel();
		p.add(q);
		p.add(a);
		return p;
	}
}
