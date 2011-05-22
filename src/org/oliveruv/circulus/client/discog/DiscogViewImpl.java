package org.oliveruv.circulus.client.discog;

import java.util.HashMap;

import org.oliveruv.circulus.client.resources.BundledResources;
import org.oliveruv.circulus.shared.ReleaseItem;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.inject.Inject;

public class DiscogViewImpl extends Composite implements DiscogView {

	private Presenter discogActivity;
	private BundledResources res;
	private FlowPanel panel = new FlowPanel();
	private FlowPanel contentPanel = new FlowPanel();
	private FlowPanel albumsPanel = new FlowPanel();
	private HashMap<String, ReleaseItem> albumMap = null; 
	
	@Override
	public void setPresenter(Presenter presenter) {
		if (discogActivity == null) {
			discogActivity = presenter;
			albumMap = discogActivity.getDiscog();
			AddLinksToPanel(albumMap);
			SetFocusedLink(discogActivity.getCurrentAlbum());
			SetContent(albumMap.get(discogActivity.getCurrentAlbum()));
		} else {
			SetFocusedLink(discogActivity.getCurrentAlbum());
			SetContent(albumMap.get(discogActivity.getCurrentAlbum()));
		}
	}

	@Inject
	public DiscogViewImpl(BundledResources resources) {
		super();
		res = resources;
		contentPanel.setStyleName(res.css().contentPane());
		albumsPanel.setStyleName(res.css().albumPane());
		
		SetContent(null);
		
		panel.add(contentPanel);
		panel.add(albumsPanel);
		
		initWidget(panel);
	}

	private void SetFocusedLink(String currentAlbum) {
		
	}

	private void AddLinksToPanel(HashMap<String, ReleaseItem> albums) {
		
	}
	
	private void SetContent(ReleaseItem album) {
		contentPanel.clear();
		if (album == null) {
			Label title = new Label("Discografia");
			title.setStyleName(res.css().contentTitle());
			contentPanel.add(title);
		} else {
			Label title = new Label(album.getName());
			title.setStyleName(res.css().contentTitle());
			contentPanel.add(title);
		}
	}
}
