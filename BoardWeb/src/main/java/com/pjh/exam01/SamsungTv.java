package com.pjh.exam01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("tv")
public class SamsungTv implements TV {
	
	@Autowired
	private Speaker speaker;
	
	/*public SamsungTv(Speaker speaker) {
		this.speaker = speaker;
	}*/

	public SamsungTv() {
		System.out.println("삼성티비등장");
	}
	
	@Override
	public void on() {
		System.out.println("삼설티비온");

	}

	@Override
	public void off() {
		System.out.println("삼성티비오프");

	}

	public void up() {
		speaker.up();
	}
	public void down() {
		speaker.down();
	}
}
