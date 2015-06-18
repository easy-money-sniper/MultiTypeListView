package com.xuliang.multitypelistview;

public class Msg {

	private String name;
	private int resourceId;
	private int mType;

	public int getmType() {
		return mType;
	}

	public void setmType(int mType) {
		this.mType = mType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getResourceId() {
		return resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

	@Override
	public String toString() {
		return "Msg [name=" + name + ", resourceId=" + resourceId + ", mType="
				+ mType + "]";
	}

	

}
