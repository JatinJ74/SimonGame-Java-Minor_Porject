package com.gvacharya.simongame;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.*;
import javax.swing.Timer;

public class SimonGame extends JFrame implements ActionListener{
	
	private List<Integer> sequence;
	
	private List<JButton> buttons;
	
	private int currentStep;
	
	private boolean PlayerTurn;
	
	private Timer timer;
	
	private int currentFlash;
	
	public SimonGame() {
		
		setTitle("Simon Game by JatinJ74");
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(2,2));
		
		sequence = new ArrayList<>();
		buttons = new ArrayList<>();
		currentStep = 0;
		PlayerTurn = false;
		
		for(int i=0;i<4;i++) {
			JButton button = new SimonButton(i);
			button.addActionListener(this);
			buttons.add(button);
			add(button);
			
		}
		
		newRound();
		setVisible(true);
			
	}

	private void newRound() {
		Random random = new Random();
		sequence.add(random.nextInt(4));
		currentStep = 0;
		PlayerTurn = false;
		playSequence();
		
	}

	private void playSequence() {
		timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(currentFlash < sequence.size()) {
					buttons.get(sequence.get(currentFlash)).setBackground(Color.white);
					Timer pause = new Timer(500, new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							buttons.get(sequence.get(currentFlash)).setBackground(getButtonColor(sequence.get(currentFlash)));
							currentFlash++;
						}

						
					});
					pause.setRepeats(false);
					pause.start();
				}else {
					timer.stop();
					PlayerTurn = true;
				}
			}
		});
		currentFlash = 0;
		timer.setRepeats(true);
		timer.start();
	}
	
	private Color getButtonColor(Integer index) {
		switch(index) {
		case 0 : return Color.red;
		case 1: return Color.blue;
		case 2: return Color.green;
		case 4: return Color.yellow;
		default: return Color.black; 
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if(!PlayerTurn) return;
		
		SimonButton button = (SimonButton) e.getSource();
		if(button.getIndex() == sequence.get(currentStep)) {
			currentStep++;
			if(currentStep == sequence.size()) {
				PlayerTurn = false;
				newRound();
			}
		}else {
			JOptionPane.showMessageDialog(this, "Game Over! Your Score: " + (sequence.size()-1));
			sequence.clear();
			newRound();
		}
	}
}
