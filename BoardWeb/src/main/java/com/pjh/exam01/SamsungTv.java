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
		System.out.println("�ＺƼ�����");
	}
	
	@Override
	public void on() {
		System.out.println("�ＳƼ���");

	}

	@Override
	public void off() {
		System.out.println("�ＺƼ�����");

	}

	public void up() {
		speaker.up();
	}
	public void down() {
		speaker.down();
	}
}
