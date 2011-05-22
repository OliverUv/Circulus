package org.oliveruv.circulus.client.bio;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

public interface BioView extends IsWidget {
	void setPresenter(Presenter presenter);
	
	public interface Presenter {
		void setView(BioView view);
		Widget getBio();
	}
}
