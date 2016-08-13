package org.cs27x.dropbox;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.config.NetworkConfig;
import com.hazelcast.core.Cluster;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ITopic;
import com.hazelcast.core.MemberAttributeEvent;
import com.hazelcast.core.MembershipEvent;
import com.hazelcast.core.MembershipListener;
import com.hazelcast.core.Message;
import com.hazelcast.core.MessageListener;

public class HazelcastTransport implements DropboxTransport,
		MessageListener<DropboxCmd>, MembershipListener {

	private static final String LOCALHOST = "localhost";

	private static final String LOOPBACK = "127.0.0.1";

	private static final String DEFAULT_TOPIC = "default";

	private ITopic<DropboxCmd> topic_;
	
	private boolean connected_ = false;

	private HazelcastInstance instance_;
	
	private List<DropboxTransportListener> listeners_ = new ArrayList<>(1);

	@Override
	public void connect(String initialPeer) throws Exception {
		
		if (initialPeer != null) {
			
			initialPeer = (initialPeer.equals("local"))? LOOPBACK : initialPeer;
			
			Config cfg = new Config();

			cfg.setInstanceName("Client-"+UUID.randomUUID().toString());
			
			NetworkConfig network = cfg.getNetworkConfig()
					.setPort(5701)
					.setPortAutoIncrement(true);
			
			JoinConfig join = network.getJoin();
			join.getMulticastConfig()
					.setEnabled(false);
			join.getTcpIpConfig()
					.setRequiredMember(initialPeer)
					.setEnabled(true);

			instance_ = Hazelcast.getOrCreateHazelcastInstance(cfg);
		}
		else {
			Config cfg = new Config();
			
			cfg.setInstanceName("Discovery-"+UUID.randomUUID().toString());
			NetworkConfig network = cfg.getNetworkConfig()
				.setPort(5701);
			network.getInterfaces()
				.setEnabled(true)
				.addInterface(LOOPBACK)
				.addInterface(LOCALHOST);
			
			network.setPortAutoIncrement(true);
			JoinConfig join = network.getJoin();
			join.getMulticastConfig().setEnabled(false);

			join.getTcpIpConfig()
					.setEnabled(true);
			
			instance_ = Hazelcast.newHazelcastInstance(cfg);
		}

		Cluster cluster = instance_.getCluster();
		cluster.addMembershipListener(this);
		topic_ = instance_.getTopic(DEFAULT_TOPIC);
		topic_.addMessageListener(this);
	
		checkConnected();
	}

	public void disconnect(){
		instance_.shutdown();
	}

	private void checkConnected(){
		Cluster cluster = instance_.getCluster();
		if(cluster.getMembers().size() > 1 && !connected_){
			connected();
		} else if(connected_){
			disconnected();
		}
	}
	
	public synchronized void connected(){
		connected_ = true;
		for(DropboxTransportListener l : listeners_){
			l.connected(this);
		}
		notifyAll();
	}
	
	public synchronized void disconnected(){
		connected_ = false;
		for(DropboxTransportListener l : listeners_){
			l.disconnected(this);
		}
		notifyAll();
	}

	@Override
	public void onMessage(Message<DropboxCmd> cmd) {
		for (DropboxTransportListener l : listeners_) {
			l.cmdReceived(cmd.getMessageObject());
		}
	}

	@Override
	public void publish(DropboxCmd cmd) {
		topic_.publish(cmd);
	}

	public void addListener(DropboxTransportListener hdlr) {
		listeners_.add(hdlr);
	}

	public boolean isConnected() {
		return connected_;
	}
	
	public synchronized void awaitConnect(long timeout) throws InterruptedException {
		if(!connected_){
			if(timeout > 0){
				wait(timeout);
			}else {
				wait();
			}
		}
	}
	
	@Override
	public void memberAdded(MembershipEvent arg0) {
		checkConnected();
	}

	@Override
	public void memberRemoved(MembershipEvent arg0) {
		checkConnected();
	}

	@Override
	public void memberAttributeChanged(MemberAttributeEvent memberAttributeEvent) {
		
	}
}
