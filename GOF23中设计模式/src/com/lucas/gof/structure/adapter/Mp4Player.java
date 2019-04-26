package com.lucas.gof.structure.adapter;

public class Mp4Player extends AdvancedAbstractMediaPlayer{

	@Override
	public void playMp4(String fileName) {
		System.out.println("Playing mp4 file. Name: "+fileName);
	}
	

}
