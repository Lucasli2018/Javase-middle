package com.lucas.gof.structure.adapter;

public class VlcPlayer implements AdvancedMediaPlayer{

	@Override
	public void playVlc(String filaName) {
		System.out.println("Playing vlc file. Name: "+filaName);
	}

	@Override
	public void playMp4(String fileName) {
		
	}

}
