package org.cs27x.dropbox;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class DefaultFileManager implements FileManager {

	private final Path rootDir_;
	
	public DefaultFileManager(Path rootdir){
		rootDir_ = rootdir;
	}
	
	@Override
	public boolean exists(Path p){
		return Files.exists(p);
	}
	
	@Override
	public void write(Path p, byte[] data, boolean overwrite) throws IOException{
		
		if (!Files.exists(p) || overwrite) {
			try (OutputStream out = Files.newOutputStream(p)) {
				out.write(data);
			}
		}
	}
	
	@Override
	public void delete(Path p) throws IOException {
		if(Files.exists(p)){
			Files.delete(p);
		}
	}

	@Override
	public Path resolve(String relativePathName) {
		return rootDir_.resolve(relativePathName);
	}
	
}
