package org.oliveruv.circulus.client.welcome;

import com.google.gwt.user.client.ui.IsWidget;

public interface WelcomeView extends IsWidget {
	void setPresenter(Presenter presenter);
	
	public interface Presenter {
		void setView(WelcomeView view);
		String getWelcome();
	}
}
