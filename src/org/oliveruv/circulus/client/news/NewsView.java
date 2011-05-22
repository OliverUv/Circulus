package org.oliveruv.circulus.client.news;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

public interface NewsView extends IsWidget {
	void setPresenter(Presenter presenter);
	void setTitle(String newTitle);
	void resetTitle();
	
	public interface Presenter {
		void setView(NewsView view);
		Widget getNews();
		Widget getNextPageLink();
		boolean hasNextPage();
	}
}
