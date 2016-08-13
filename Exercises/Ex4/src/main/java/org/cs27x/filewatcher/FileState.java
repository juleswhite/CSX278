package org.cs27x.filewatcher;

import java.nio.file.attribute.FileTime;

public class FileState {

	private long size_;
	private FileTime lastModificationDate_;

	public FileState(long size, FileTime lastModificationDate) {
		super();
		size_ = size;
		lastModificationDate_ = lastModificationDate;
	}

	public long getSize() {
		return size_;
	}

	public void setSize(long size) {
		size_ = size;
	}

	public FileTime getLastModificationDate() {
		return lastModificationDate_;
	}

	public void setLastModificationDate(FileTime lastModificationDate) {
		lastModificationDate_ = lastModificationDate;
	}

}
