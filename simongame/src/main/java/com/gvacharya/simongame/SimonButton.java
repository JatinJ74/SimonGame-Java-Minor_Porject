package com.gvacharya.simongame;

import java.awt.Color;

import javax.swing.JButton;

public class SimonButton extends JButton {

	private int index;

	public SimonButton(int index) {
		this.index = index;
		setOpaque(true);
		setBorderPainted(false);
		setBackground(getButtonColor());
	}

	private Color getButtonColor() {
		switch(index) {
		case 0 : return Color.red;
		case 1: return Color.blue;
		case 2: return Color.green;
		case 4: return Color.yellow;
		default: return Color.black; 
		}
	}
	
	public int getIndex() {
		return index;
	}
}
