package tw.com.fcb.fcb_music;

import java.io.Serializable;

public class JavaBean implements Serializable {

	private String name = null;
	private String face = null;
	private String belong = null;
	
	public String getBelong() {
		return belong;
	}

	public void setBelong(String belong) {
		this.belong = belong;
	}

	public JavaBean() {
		// TODO Auto-generated constructor stub
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFace() {
		return face;
	}

	public void setFace(String face) {
		this.face = face;
	}

	@Override
	public String toString() {
		return "JavaBean [name=" + name + ", face=" + face + ", belong=" + belong + "]";
	}

}
