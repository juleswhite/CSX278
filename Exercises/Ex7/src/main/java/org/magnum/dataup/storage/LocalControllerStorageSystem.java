/* 
 **
 ** Copyright 2014, Jules White
 **
 ** 
 */
package org.magnum.dataup.storage;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.magnum.dataup.VideoSvcApi;
import org.magnum.dataup.model.Video;
import org.magnum.dataup.model.VideoNotFoundException;
import org.magnum.dataup.model.VideoRepository;
import org.magnum.dataup.model.VideoStatus;
import org.magnum.dataup.model.VideoStatus.VideoState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class LocalControllerStorageSystem implements VideoStorageSystem {

	@Autowired
	private VideoRepository videoRepository_;
	private VideoFileManager videoDataRepository_ = new VideoFileManager();

	@RequestMapping(method = RequestMethod.GET, value = VideoSvcApi.VIDEO_DATA_PATH)
	public void downloadVideo(@PathVariable(VideoSvcApi.ID_PARAMETER) long id,
			HttpServletResponse response) throws IOException {

		Video v = videoRepository_.findOne(id);
		try {
			videoDataRepository_.copyVideoData(v, response);
		} catch (Exception e) {
			throw new VideoNotFoundException(v);
		}
	}

	@ExceptionHandler(VideoNotFoundException.class)
	public void handleError(HttpServletRequest req, HttpServletResponse resp,
			VideoNotFoundException exception) throws Exception {
		Video v = exception.getVideo();
		resp.setStatus(404);
		resp.setContentType("text/html");
		resp.getWriter()
				.println(
						"<html><body>" + v.getTitle()
								+ " was not found.</body></html>");
	}

	@RequestMapping(method = RequestMethod.POST, value = VideoSvcApi.VIDEO_DATA_PATH)
	public void uploadVideo(
			@PathVariable(VideoSvcApi.ID_PARAMETER) long id,
			@RequestParam(VideoSvcApi.DATA_PARAMETER) MultipartFile videoData,
			HttpServletResponse response) throws IOException {

		Video video = videoRepository_.findOne(id);

		if (video != null) {
			videoDataRepository_.saveVideoData(video,
					videoData.getInputStream());
			
			response.sendRedirect(video.getDataUrl());
		} else {
			response.sendError(404, "Video not found");
		}
	}

	private String getUrlBaseForLocalServer() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		String base = "http://"
				+ request.getServerName()
				+ ((request.getServerPort() != 80) ? ":"
						+ request.getServerPort() : "");
		return base;
	}

	public String getVideoUrl(Video v) {
		String base = getUrlBaseForLocalServer();
		return base
				+ VideoSvcApi.VIDEO_DATA_PATH.replace("{"
						+ VideoSvcApi.ID_PARAMETER + "}", "" + v.getId());
	}

}
