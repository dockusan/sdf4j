package org.sdf4j.core;

public class Image {

	private String name; 
	private byte[] data;
	
	public Image(String name, byte[] data) {
		super();
		this.name = name;
		this.data = data;
	}

	public String getName() {
		return name;
	}

	public byte[] getData() {
		return data;
	}
}
