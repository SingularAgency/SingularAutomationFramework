package com.appium.util;

public enum Device {

	IOS("ios"), ANDROID("android");
	String deviceName;

	Device(String deviceName) {
		this.deviceName = deviceName;
	}

	public String toString() {
		return deviceName;
	}
}
