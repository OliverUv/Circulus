package org.oliveruv.circulus.client.media;

import java.util.HashMap;

import org.oliveruv.circulus.shared.Ukuria;

import com.google.gwt.user.client.ui.IsWidget;

public interface MediaView extends IsWidget {
	void setPresenter(Presenter presenter);
	
	public interface Presenter {
		void setView(MediaView view);
		HashMap<String, Ukuria> getUkuria();
		String getCurrentUkuria();
	}
}
