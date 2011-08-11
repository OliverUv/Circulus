package org.oliveruv.circulus.shared;

import com.google.gwt.user.client.ui.Widget;

public class Ukuria {
	public String getUrlTitle() {
		return urlTitle;
	}
	public void setUrlTitle(String urlTitle) {
		this.urlTitle = urlTitle;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Widget getContent() {
		return content;
	}
	public void setContent(Widget content) {
		this.content = content;
	}
	private String urlTitle;
	private String title;
	private Widget content;
	public Ukuria(String urlTitle, String title, Widget content) {
		super();
		this.urlTitle = urlTitle;
		this.title = title;
		this.content = content;
	}
	
}
