package com.pjh.exam01;

import org.springframework.stereotype.Component;

@Component("apple")
public class AppleSpeaker implements Speaker {

	public  AppleSpeaker() {
		System.out.println("局敲胶乔目按眉积己");
	}
	@Override
	public void up() {
		System.out.println("家府诀");

	}

	@Override
	public void down() {
		System.out.println("家府促款");

	}

}
