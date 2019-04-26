package com.lucas.gof.structure.adapter;

public class VlcPlayer extends AdvancedAbstractMediaPlayer {

	@Override
	public void playVlc(String filaName) {
		System.out.println("Playing vlc file. Name: "+filaName);
	}
}
