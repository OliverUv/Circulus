package org.oliveruv.circulus.shared;

public class ReleaseTrack {
	private int number;
	private String name;
	private int minutes;
	private int seconds;
	private String featuring;
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	public String getFeaturing() {
		return featuring;
	}

	public void setFeaturing(String featuring) {
		this.featuring = featuring;
	}

	public ReleaseTrack(int number, String name, int minutes, int seconds,
			String featuring) {
		super();
		this.number = number;
		this.name = name;
		this.minutes = minutes;
		this.seconds = seconds;
		this.featuring = featuring;
	}
	
	public ReleaseTrack(int number, String name, int minutes, int seconds) {
		super();
		this.number = number;
		this.name = name;
		this.minutes = minutes;
		this.seconds = seconds;
		this.featuring = "";
	}
}
