package com.pjh.exam01;

import org.springframework.stereotype.Component;

@Component("apple")
public class AppleSpeaker implements Speaker {

	public  AppleSpeaker() {
		System.out.println("���ý���Ŀ��ü����");
	}
	@Override
	public void up() {
		System.out.println("�Ҹ���");

	}

	@Override
	public void down() {
		System.out.println("�Ҹ��ٿ�");

	}

}
