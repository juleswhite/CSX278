/* 
**
** Copyright 2014, Jules White
**
** 
*/
package org.magnum.dataup.model;


public interface VideoRepository {
	
	public Video save(Video entity);

	public Video findOne(long id);
	
	public Iterable<Video> findAll();
}
