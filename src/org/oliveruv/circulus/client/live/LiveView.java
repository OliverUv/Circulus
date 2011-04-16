package org.oliveruv.circulus.client.live;

import com.google.gwt.user.client.ui.IsWidget;

public interface LiveView extends IsWidget {
	void setPresenter(Presenter presenter);
	
	public interface Presenter {
		void setView(LiveView view);
		String getLiveInfo();
	}
}
