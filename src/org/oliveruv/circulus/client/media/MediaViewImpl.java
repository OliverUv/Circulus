package org.oliveruv.circulus.client.media;

import org.oliveruv.circulus.client.mvp.CirculusPlaceHistoryMapper;
import org.oliveruv.circulus.client.resources.BundledResources;
import org.oliveruv.circulus.shared.Ukuria;

import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.inject.Inject;

public class MediaViewImpl extends Composite implements MediaView {

	private Presenter mediaActivity;
	private BundledResources res;
	private FlowPanel panel = new FlowPanel();
	private CirculusPlaceHistoryMapper mapper;
	
	@Override
	public void setPresenter(Presenter presenter) {
		mediaActivity = presenter;
		panel.clear();
		
		Ukuria u = presenter.getUkuria().get(presenter.getCurrentUkuria());
		
		if (presenter.getCurrentUkuria().equals("") || u == null) {
			Label title = new Label("Gentle fields greet our sunrise.");
			title.setStyleName(res.css().contentTitle());
			panel.add(title);
			
			Label ukuriaIntro = new Label("Ukuria was once a wondrous city in the land now called Jordan. It lies buried beneath the sands, having gone into decline some twenty thousand years ago. This is the place from which we have come into this time and now is a time for wonderful transformation. Come with us on our yellow journey - to dive the mind and pick up some special powers along the way.");
			ukuriaIntro.setStyleName(res.css().contentText());
			ukuriaIntro.addStyleName(res.css().mediaIndentation());
			panel.add(ukuriaIntro);
			
			ukuriaIntro = new Label("Ukuria held us blessed as her spirits embraced us motherly. Wrapped us in the warm and close, so we could sink and sink into the womb of it all.");
			ukuriaIntro.setStyleName(res.css().contentText());
			ukuriaIntro.addStyleName(res.css().mediaIndentation());
			panel.add(ukuriaIntro);
			
			for(Ukuria i : presenter.getUkuria().values()) {
				Hyperlink l = new Hyperlink(i.getTitle(), mapper.getToken(new MediaPlace(i.getUrlTitle())));
				l.setStyleName(res.css().mediaItem());
				panel.add(l);
			}
		} else {
			
			Label title = new Label(u.getTitle());
			title.setStyleName(res.css().contentTitle());
			panel.add(title);
			
			panel.add(u.getContent());
		}
		
	}

	@Inject
	public MediaViewImpl(BundledResources resources, CirculusPlaceHistoryMapper mapper) {
		super();
		this.res = resources;
		this.mapper = mapper;
		panel.setStyleName(res.css().contentPane());
		initWidget(panel);
	}
}
