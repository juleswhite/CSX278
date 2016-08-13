/* 
 **
 ** Copyright 2014, Jules White
 **
 ** 
 */
package org.magnum.dataup.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fluentinterface.ReflectionBuilder;
import com.fluentinterface.builder.Builder;

public class Video {

	public static VideoBuilder create() {
		return ReflectionBuilder.implementationFor(VideoBuilder.class).create();
	}

	public interface VideoBuilder extends Builder<Video> {
		public VideoBuilder withTitle(String title);

		public VideoBuilder withDuration(long duration);

		public VideoBuilder withSubject(String subject);

		public VideoBuilder withContentType(String contentType);
	}

	private long id;
	private String title;
	private long duration;
	private String location;
	private String subject;
	private String contentType;

	private String dataUrl;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDataUrl() {
		return dataUrl;
	}

	public void setDataUrl(String dataUrl) {
		this.dataUrl = dataUrl;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(getTitle(), getDuration());
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof Video)
				&& Objects.equals(getTitle(), ((Video) obj).getTitle())
				&& getDuration() == ((Video) obj).getDuration();
	}

}
