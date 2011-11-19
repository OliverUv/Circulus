package org.oliveruv.circulus.client.live;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

public interface LiveView extends IsWidget {
	void setPresenter(Presenter presenter);
	
	public interface Presenter {
		void setView(LiveView view);
		String getLiveInfo();
		Widget getLiveActItems();
	}
}
