package org.magnum.dataup.model;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryVideoRepository implements VideoRepository {

	private static final AtomicLong currentId_ = new AtomicLong(0L);
	
	private Map<Long,Video> videos_ = new HashMap<Long, Video>();
	
	@Override
	public Video save(Video entity) {
		checkAndSetId(entity);
		videos_.put(entity.getId(), entity);
		return entity;
	}

	private void checkAndSetId(Video entity) {
		if(entity.getId() == 0){
			entity.setId(currentId_.incrementAndGet());
		}
	}

	@Override
	public Video findOne(long id) {
		return videos_.get(id);
	}

	@Override
	public Iterable<Video> findAll() {
		return videos_.values();
	}

}
