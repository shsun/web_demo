package com.youdo.ad.entry;

/**
 * 
 * @author shsun
 * 
 */
public class AdAsset extends IdNameObject {

	public enum ContentType {
		VIDEO, HTML, IMAGE, SWF, UNKNOWN
	}

	public enum DurationType {
		SECONDS_LESS_THAN_MIN_DURATION, SECONDS_3, SECONDS_5, SECONDS_10, SECONDS_15, SECONDS_30, SECONDS_GREATER_THAN_MAX_DURATION
	}

	// -------------------------------------------------------------------------------------------------------------------------
	//
	private static final String PREFIX_HTTP = "http://";
	private static final String PREFIX_HTTPS = "https://";

	private static final int DURATION_MAX = 30;
	private static final int DURATION_LESS_THAN_MIN = Integer.MIN_VALUE;
	private static final int DURATION_GREATER_THAN_MAX = Integer.MAX_VALUE;

	// -------------------------------------------------------------------------------------------------------------------------
	private int duration;
	private String url;
	private int priority;
	private AdAsset.ContentType contentType;
	private AdAsset.DurationType durationType;

	// -------------------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * @param id
	 * @param name
	 * @param url
	 * @param duration
	 * @param contentType
	 */
	public AdAsset(int id, String name, String url, int priority, int duration, int contentType) {
		super(id, name);
		this.setUrl(url);
		this.setPriority(priority);
		this.setDuration(duration);
		if (this.getDuration() < 0) {
			this.durationType = AdAsset.DurationType.SECONDS_LESS_THAN_MIN_DURATION;
		} else if (this.getDuration() <= 3) {
			this.durationType = AdAsset.DurationType.SECONDS_3;
		} else if (this.getDuration() <= 5) {
			this.durationType = AdAsset.DurationType.SECONDS_5;
		} else if (this.getDuration() <= 10) {
			this.durationType = AdAsset.DurationType.SECONDS_10;
		} else if (this.getDuration() <= 15) {
			this.durationType = AdAsset.DurationType.SECONDS_15;
		} else if (this.getDuration() <= 30) {
			this.durationType = AdAsset.DurationType.SECONDS_30;
		} else {
			this.durationType = AdAsset.DurationType.SECONDS_GREATER_THAN_MAX_DURATION;
		}
		// TODO
		this.setContentType(AdAsset.ContentType.VIDEO);
	}

	// -------------------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * @return
	 */
	public boolean isValid() {
		return this.isValidURL() && this.isValidDuration();
	}

	/**
	 * 
	 * @return
	 */
	public boolean isValidURL() {
		boolean valid = false;
		if (this.getUrl() != null) {
			String tmpURL = this.getUrl();
			valid = tmpURL.indexOf(PREFIX_HTTP) == 0 || tmpURL.indexOf(PREFIX_HTTPS) == 0;
		}
		return valid;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isValidDuration() {
		return (this.getDurationType() != AdAsset.DurationType.SECONDS_LESS_THAN_MIN_DURATION) && (this.getDurationType() != AdAsset.DurationType.SECONDS_GREATER_THAN_MAX_DURATION);
	}

	// -------------------------------------------------------------------------------------------------------------------------
	public int getDuration() {
		return duration;
	}

	public void setDuration( int duration ) {
		if (duration < 0) {
			this.duration = DURATION_LESS_THAN_MIN;
		} else if (duration > DURATION_MAX) {
			this.duration = DURATION_GREATER_THAN_MAX;
		} else {
			this.duration = duration;
		}
	}

	// -------------------------------------------------------------------------------------------------------------------------
	public String getUrl() {
		return url;
	}

	public void setUrl( String url ) {
		if (url != null) {
			this.url = url.trim().toLowerCase();
		}
	}

	// -------------------------------------------------------------------------------------------------------------------------
	public int getPriority() {
		return priority;
	}

	public void setPriority( int priority ) {
		this.priority = priority;
	}

	// -------------------------------------------------------------------------------------------------------------------------
	public AdAsset.ContentType getContentType() {
		return contentType;
	}

	public void setContentType( AdAsset.ContentType contentType ) {
		this.contentType = contentType;
	}

	// -------------------------------------------------------------------------------------------------------------------------
	public AdAsset.DurationType getDurationType() {
		return durationType;
	}

}
