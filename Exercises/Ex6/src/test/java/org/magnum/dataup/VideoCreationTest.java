package org.magnum.dataup;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.magnum.dataup.model.Video;
import org.magnum.dataup.model.VideoStatus;
import org.magnum.dataup.model.VideoStatus.VideoState;

import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.mime.TypedFile;

public class VideoCreationTest {

	private static final String SERVER = "http://localhost:8080";

	private File testVideoData = new File(
			"src/test/resources/test.mp4");
	
	private Video video = Video.create().withContentType("video/mpeg")
			.withDuration(123).withSubject("Test")
			.withTitle(UUID.randomUUID().toString()).build();

	private VideoSvcApi videoSvc = new RestAdapter.Builder()
			.setEndpoint(SERVER).build()
			.create(VideoSvcApi.class);

	@Test
	public void testAddVideoMetadata() throws Exception {
		Video received = videoSvc.addVideo(video);
		assertEquals(video.getTitle(), received.getTitle());
		assertEquals(video.getDuration(), received.getDuration());
		assertEquals(video.getContentType(), received.getContentType());
		assertEquals(video.getLocation(), received.getLocation());
		assertEquals(video.getSubject(), received.getSubject());
		assertTrue(received.getId() > 0);
		assertTrue(received.getDataUrl() != null);
	}
	
	@Test
	public void testAddGetVideo() throws Exception {
		videoSvc.addVideo(video);
		Collection<Video> stored = videoSvc.getVideoList();
		assertTrue(stored.contains(video));
	}
	
	@Test
	public void testGetNonExistantVideosData() throws Exception {
		
		long nonExistantId = getInvalidVideoId();
		
		try{
			Response r = videoSvc.getData(nonExistantId);
			assertEquals(404, r.getStatus());
		}catch(RetrofitError e){
			assertEquals(404, e.getResponse().getStatus());
		}
	}
	
	@Test
	public void testAddNonExistantVideosData() throws Exception {
		long nonExistantId = getInvalidVideoId();
		try{
			videoSvc.setVideoData(nonExistantId, new TypedFile(video.getContentType(), testVideoData));
			fail("The client should receive a 404 error code and throw an exception if an invalid"
					+ " video ID is provided in setVideoData()");
		}catch(RetrofitError e){
			assertEquals(404, e.getResponse().getStatus());
		}
	}

	private long getInvalidVideoId() {
		Set<Long> ids = new HashSet<Long>();
		Collection<Video> stored = videoSvc.getVideoList();
		for(Video v : stored){
			ids.add(v.getId());
		}
		
		long nonExistantId = Long.MIN_VALUE;
		while(ids.contains(nonExistantId)){
			nonExistantId++;
		}
		return nonExistantId;
	}

}
