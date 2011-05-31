package org.oliveruv.circulus.client.discog;

import java.util.HashMap;
import java.util.Map;

import org.oliveruv.circulus.client.mvp.CirculusPlaceHistoryMapper;
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

	private Presenter discogActivity = null;
	private BundledResources res;
	private FlowPanel panel = new FlowPanel();
	private FlowPanel contentPanel = new FlowPanel();
	private FlowPanel currentAlbumPanel = new FlowPanel();
	private FlowPanel albumsPanel = new FlowPanel();
	private HashMap<String, ReleaseItem> albumMap = null;
	private HashMap<String, Image> imageMap = null;
	private HashMap<String, Hyperlink> linkMap = null;
	private CirculusPlaceHistoryMapper mapper;
	
	@Override
	public void setPresenter(Presenter presenter) {
		if (discogActivity == null) {
			discogActivity = presenter;
			
			//Initialize
			albumMap = discogActivity.getDiscog();
			createImagesLinks();
			
			arrangeLinks(discogActivity.getCurrentAlbum());
			setContent(albumMap.get(discogActivity.getCurrentAlbum()));
			
		} else {
			discogActivity = presenter;
			arrangeLinks(discogActivity.getCurrentAlbum());
			setContent(albumMap.get(discogActivity.getCurrentAlbum()));
		}
	}

	@Inject
	public DiscogViewImpl(BundledResources resources, CirculusPlaceHistoryMapper mapper) {
		super();
		res = resources;
		this.mapper = mapper;
		contentPanel.setStyleName(res.css().contentPane());
		albumsPanel.setStyleName(res.css().albumsPane());
		currentAlbumPanel.setStyleName(res.css().currentAlbumPane());
		
		
		setContent(null);
		
		panel.add(contentPanel);
		panel.add(albumsPanel);
		panel.add(currentAlbumPanel);
		
		initWidget(panel);
	}

	private void arrangeLinks(String currentAlbum) {
		albumsPanel.clear();
		currentAlbumPanel.clear();
		
		for(Map.Entry<String, Hyperlink> i : linkMap.entrySet()) {
			if (i.getKey() != currentAlbum)
				albumsPanel.add(i.getValue());
		}
		
		Image i = imageMap.get(currentAlbum);
		i.setSize("auto", "30%");
		currentAlbumPanel.add(i);
	}

	private void createImagesLinks() {
		imageMap = new HashMap<String, Image>();
		linkMap = new HashMap<String, Hyperlink>();
		
		for(ReleaseItem i : albumMap.values()) {
			Image image = new Image(i.getAlbumCover());
			image.setAltText(i.getName());
			image.setSize("auto", "15%");
			imageMap.put(i.getKey(), image);
		}
		
		for(ReleaseItem i : albumMap.values()) {
			Hyperlink l = new Hyperlink(imageMap.get(i.getKey()).getElement().getString(), true, mapper.getToken(new DiscogPlace(i.getKey())));
			linkMap.put(i.getKey(), l);
		}
	}
	
	private void setContent(ReleaseItem album) {
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
