package org.oliveruv.circulus.client.discog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.oliveruv.circulus.client.mvp.CirculusPlaceHistoryMapper;
import org.oliveruv.circulus.client.resources.BundledResources;
import org.oliveruv.circulus.shared.ReleaseItem;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class DiscogViewImpl extends Composite implements DiscogView {

	private Presenter discogActivity = null;
	private BundledResources res;
	private FlowPanel panel = new FlowPanel();
	private FlowPanel contentPanel = new FlowPanel();
	private FlowPanel albumPanel = new FlowPanel();
	private HashMap<String, ReleaseItem> albumMap = null;
	private HashMap<String, Element> imageMap = null;
	private ArrayList<String> albumPositions = new ArrayList<String>();
	private CirculusPlaceHistoryMapper mapper;
	
	@Override
	public void setPresenter(Presenter presenter) {
		if (discogActivity == null) {
			discogActivity = presenter;
			
			//Initialize
			albumMap = discogActivity.getDiscog();
			createImagesAndLinks();
			
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
		albumPanel.setStyleName(res.css().albumPane());
		
		albumPositions.add(res.css().albumOne());
		albumPositions.add(res.css().albumTwo());
		albumPositions.add(res.css().albumThree());
		
		setContent(null);
		
		panel.add(contentPanel);
		panel.add(albumPanel);
		
		initWidget(panel);
	}

	private void arrangeLinks(String currentAlbum) {
		albumPanel.clear();
		
		int n = 0;
		int albumsWithLinks = albumMap.containsKey(currentAlbum) ? albumMap.size() -1 : albumMap.size();
		for(Map.Entry<String, ReleaseItem> i : albumMap.entrySet()) {
			if (! i.getKey().equals(currentAlbum)) {
				addAlbumLink(i.getValue(), n, albumsWithLinks);
				n++;
			}
		}
		
		//Add current album
		if (imageMap.containsKey(currentAlbum))
			albumPanel.add(new HTML(imageMap.get(currentAlbum).getString()));
	}

	private void addAlbumLink(ReleaseItem album, int linkInSeries, int totalInSeries) {
		if (linkInSeries >= albumPositions.size())
			return;
		
		albumPanel.add(createImageLink(album, albumPositions.get(linkInSeries)));
	}
	
	private Hyperlink createImageLink(ReleaseItem album, String cssClassName) {
		Element img = DOM.createImg();
		img.setClassName(cssClassName);
		img.setAttribute("alt", album.getName());
		img.setAttribute("src", album.getAlbumCover().getURL());
		
		Hyperlink l = new Hyperlink(img.getString(), true, mapper.getToken(new DiscogPlace(album.getKey())));
		return l;
	}

	private void createImagesAndLinks() {
		imageMap = new HashMap<String, Element>();

		for(ReleaseItem i : albumMap.values()) {
			Element img = DOM.createImg();
			img.setClassName(res.css().currentAlbumImage());
			img.setAttribute("alt", i.getName());
			img.setAttribute("src", i.getAlbumCover().getURL());
			
			imageMap.put(i.getKey(), img);
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
