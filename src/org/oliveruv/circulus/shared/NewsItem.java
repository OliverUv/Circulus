package org.oliveruv.circulus.shared;

import java.util.Date;

import org.oliveruv.circulus.client.resources.BundledResources;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class NewsItem {
	private Date time;
	private String author;
	private String contents;
	
	public NewsItem(Date time, String author, String contents) {
		super();
		this.time = time;
		this.author = author;
		this.contents = contents;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getTimeString() {
		return time.getYear() + "-" + time.getMonth() + "-" + time.getDay();
	}

}
