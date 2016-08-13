/* 
 **
 ** Copyright 2014, Jules White
 **
 ** 
 */
package org.magnum.dataup.model;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.magnum.dataup.VideoSvcApi;
import org.magnum.dataup.storage.VideoStorageSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Lists;

@Controller
public class VideoController {

	@Autowired
	private VideoStorageSystem videoStorage_;

	@Autowired
	private VideoRepository repository_;

	@RequestMapping(value = VideoSvcApi.VIDEO_SVC_PATH, method = RequestMethod.GET)
	public @ResponseBody Collection<Video> getVideoList() {
		return Lists.newArrayList(repository_.findAll());
	}

	@RequestMapping(value = VideoSvcApi.VIDEO_SVC_PATH, method = RequestMethod.POST)
	public @ResponseBody Video addVideo(@RequestBody Video v) {
		v = repository_.save(v);
		String target = videoStorage_.getVideoUrl(v);
		if(v.getDataUrl() == null){
			v.setDataUrl(target);
		}
		return repository_.save(v);
	}


}
