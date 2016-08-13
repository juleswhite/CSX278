package org.cs27x.dropbox;

import java.io.Serializable;

public class DropboxCmd implements Serializable {

	private static final long serialVersionUID = 1L;

	public enum OpCode {
		ADD, REMOVE, UPDATE, SYNC, GET
	}

	private String from_;
	private String path_;
	private byte[] data_;
	private OpCode opCode_;

	public String getFrom() {
		return from_;
	}

	public void setFrom(String from) {
		from_ = from;
	}

	public String getPath() {
		return path_;
	}

	public void setPath(String path) {
		path_ = path;
	}

	public byte[] getData() {
		return data_;
	}

	public void setData(byte[] data) {
		data_ = data;
	}

	public OpCode getOpCode() {
		return opCode_;
	}

	public void setOpCode(OpCode opCode) {
		opCode_ = opCode;
	}

}
