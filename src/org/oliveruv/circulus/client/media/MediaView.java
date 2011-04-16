package org.oliveruv.circulus.client.media;

import com.google.gwt.user.client.ui.IsWidget;

public interface MediaView extends IsWidget {
	void setPresenter(Presenter presenter);
	
	public interface Presenter {
		void setView(MediaView view);
		String getMediaInfo();
	}
}
