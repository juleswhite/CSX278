package org.cs27x.dropbox;

public interface DropboxTransportListener {

	public void cmdReceived(DropboxCmd cmd);
	
	public void connected(DropboxTransport t);
	
	public void disconnected(DropboxTransport t);
}
