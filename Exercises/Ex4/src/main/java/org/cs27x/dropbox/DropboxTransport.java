package org.cs27x.dropbox;

public interface DropboxTransport {

	public void connect(String host) throws Exception ;
	
	public boolean isConnected();
	
	public void publish(DropboxCmd cmd);
	
	public void addListener(DropboxTransportListener hdlr);
	
}
