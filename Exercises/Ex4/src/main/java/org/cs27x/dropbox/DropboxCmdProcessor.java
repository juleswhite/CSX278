package org.cs27x.dropbox;

import java.nio.file.Files;
import java.nio.file.Path;

import org.cs27x.dropbox.DropboxCmd.OpCode;
import org.cs27x.filewatcher.FileState;
import org.cs27x.filewatcher.FileStates;

public class DropboxCmdProcessor implements DropboxTransportListener {

	private final FileManager fileManager_;

	private final FileStates fileStates_;

	public DropboxCmdProcessor(FileStates states, FileManager mgr) {
		super();
		fileStates_ = states;
		fileManager_ = mgr;
	}

	public void updateFileState(DropboxCmd cmd, Path resolved) {
		try {
			if (cmd.getOpCode() == OpCode.REMOVE) {
				FileState state = fileStates_.getState(resolved);
				if(state != null){
					state.setSize(-1);
				}
			} else if (cmd.getOpCode() == OpCode.ADD
					|| cmd.getOpCode() == OpCode.UPDATE) {
				FileState state = fileStates_.getOrCreateState(resolved);
				state.setSize(cmd.getData().length);
				state.setLastModificationDate(Files
						.getLastModifiedTime(resolved));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void cmdReceived(DropboxCmd cmd) {
		try {

			Path resolved = fileManager_.resolve(cmd.getPath());
			OpCode op = cmd.getOpCode();

			if (op == OpCode.ADD || op == OpCode.UPDATE) {
				fileManager_
						.write(resolved, cmd.getData(), op == OpCode.UPDATE);
			} else if (op == OpCode.REMOVE) {
				fileManager_.delete(resolved);
			}
			
			updateFileState(cmd, resolved);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void connected(DropboxTransport t) {

	}

	@Override
	public void disconnected(DropboxTransport t) {

	}

}
