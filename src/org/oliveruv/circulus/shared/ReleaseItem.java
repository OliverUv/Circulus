package org.oliveruv.circulus.shared;

import java.util.ArrayList;

import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Widget;

public class ReleaseItem {
	private String key;
	private String name;
	private int year;
	private String label;
	private String releaseType; //eg ep, album, etc
	private String description;
	private ImageResource albumCover;
	
	private ArrayList<String> reviewUrls;
	private ArrayList<ReleaseTrack> tracks;
	
	
	public ReleaseItem(String key, String name, int year, String label, String releaseType, ImageResource albumCover) {
		super();
		this.key = key;
		this.name = name;
		this.year = year;
		this.label = label;
		this.releaseType = releaseType;
		this.albumCover = albumCover;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getReleaseType() {
		return releaseType;
	}

	public void setReleaseType(String releaseType) {
		this.releaseType = releaseType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArrayList<String> getReviewUrls() {
		return reviewUrls;
	}

	public void setReviewUrls(ArrayList<String> reviewUrls) {
		this.reviewUrls = reviewUrls;
	}

	public ArrayList<ReleaseTrack> getTracks() {
		return tracks;
	}

	public void setTracks(ArrayList<ReleaseTrack> tracks) {
		this.tracks = tracks;
	}

	public ImageResource getAlbumCover() {
		return albumCover;
	}

	public void setAlbumCover(ImageResource albumCover) {
		this.albumCover = albumCover;
	}
}