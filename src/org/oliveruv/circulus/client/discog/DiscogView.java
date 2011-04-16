package org.oliveruv.circulus.client.discog;

import com.google.gwt.user.client.ui.IsWidget;

public interface DiscogView extends IsWidget {
	void setPresenter(Presenter presenter);
	
	public interface Presenter {
		void setView(DiscogView view);
		String getDiscog();
	}
}
