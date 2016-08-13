/* 
**
** Copyright 2014, Jules White
**
** 
*/
package org.magnum.dataup.storage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.HttpServletResponse;

import org.magnum.dataup.model.Video;


public class VideoFileManager {

	private Path targetDir_ = Paths.get("videos");
	
	public VideoFileManager(){
		if(!Files.exists(targetDir_)){
			try{
				Files.createDirectories(targetDir_);
			}catch(Exception e){
				throw new RuntimeException(e);
			}
		}
	}
	
	public Path getVideoPath(Video v){
		return targetDir_.resolve(v.getTitle());
	}
	
	public void copyVideoData(Video v, HttpServletResponse resp) throws IOException {
		Path source = getVideoPath(v);
		if(Files.exists(source)){
			resp.setContentType(v.getContentType());
			Files.copy(source, resp.getOutputStream());
		}
		else {
			throw new FileNotFoundException();
		}
	}
	
	public void saveVideoData(Video v, InputStream videoData) throws IOException{
		Path target = getVideoPath(v);
		Files.copy(videoData, target, StandardCopyOption.REPLACE_EXISTING);
	}
	
}
