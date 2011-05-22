package org.oliveruv.circulus.client.discog;

import java.util.HashMap;

import org.oliveruv.circulus.shared.ReleaseItem;

import com.google.gwt.user.client.ui.IsWidget;

public interface DiscogView extends IsWidget {
	void setPresenter(Presenter presenter);
	
	public interface Presenter {
		void setView(DiscogView view);
		HashMap<String, ReleaseItem> getDiscog();
		String getCurrentAlbum();
	}
}
