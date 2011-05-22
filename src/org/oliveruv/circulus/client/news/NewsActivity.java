package org.oliveruv.circulus.client.news;

import java.util.ArrayList;
import java.util.List;

import org.oliveruv.circulus.client.ContentProvider;
import org.oliveruv.circulus.client.mvp.CirculusPlaceHistoryMapper;
import org.oliveruv.circulus.client.resources.BundledResources;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class NewsActivity extends AbstractActivity  implements NewsView.Presenter {

	NewsView view;
	private final ContentProvider contentProvider;
	private final BundledResources res;
	private final CirculusPlaceHistoryMapper mapper;
	public int currentPage;
	public final int itemsPerPage = 3;
	
	@Inject
	public NewsActivity(NewsView view, ContentProvider contentProvider, BundledResources resources, CirculusPlaceHistoryMapper mapper) {
		super();
		this.view = view;
		this.res = resources;
		this.contentProvider = contentProvider;
		this.mapper = mapper;
		this.currentPage = 0;
	}
	
	public void initialize(NewsPlace place) {
		currentPage = place.getCurrentPage();
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view.setPresenter(this);
		panel.setWidget(view.asWidget());
	}

	@Override
	public void setView(NewsView view) {
		this.view = view;
	}
	
	public Widget getNews() {
		return getNews(currentPage * itemsPerPage, itemsPerPage);
	}

	public Widget getNews(int from, int items) {
		List<Widget> news = contentProvider.getNewsItems(from, items);
		
		if(news.size() < 1) {
			view.setTitle("The Jester has the word.");
			return generateNoNewsMessage();
		}
		
		FlowPanel p = new FlowPanel();
		for(Widget item : news) {
			p.add(item);
		}
		
		view.resetTitle();
		return p;
	}
	
	private Widget generateNoNewsMessage() {
		Label q = new Label("What was castle Camelot famous for?");
		q.setStyleName(res.css().contentText());
		q.addStyleName(res.css().newsQuestion());
		
		Label a = new Label("Its knight life!");
		a.setStyleName(res.css().contentText());
		a.addStyleName(res.css().newsAnswer());
		
		FlowPanel p = new FlowPanel();
		p.add(q);
		p.add(a);
		return p;
	}
	
	public boolean hasNextPage() {
		int currentMaxItem = (1 + currentPage) * itemsPerPage;
		return contentProvider.hasNewsItem(currentMaxItem);
	}

	@Override
	public Widget getNextPageLink() {
		NewsPlace nextPage = new NewsPlace(currentPage+1);
		Hyperlink hl = new Hyperlink("...more news", mapper.getToken(nextPage));
		hl.setStyleName(res.css().contentText());
		hl.addStyleName(res.css().newsNext());
		new Hyperlink();
		
		return hl;
	}
}
