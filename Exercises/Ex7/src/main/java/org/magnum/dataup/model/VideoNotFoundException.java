package org.magnum.dataup.model;

public class VideoNotFoundException extends RuntimeException {

	private Video video;

	public VideoNotFoundException(Video video) {
		super();
		this.video = video;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

}
