package com.mvp.model;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

public class Color {
	private int iD;
	private String name;
	private byte[] image;
	private String base64;
	
	public Color() {
		
	}

	public Color(int iD, String name, byte[] image) {
		super();
		this.iD = iD;
		this.name = name;
		this.image = image;
		this.base64 = Base64.encode(image);
	}
	

	public String getBase64() {
		return base64;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public void setBase64(String base64) {
		this.base64 = base64;
	}

	public int getiD() {
		return iD;
	}
	public void setiD(int iD) {
		this.iD = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
