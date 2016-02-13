package com.gmail.sigmatheprogrammer.states;

import java.awt.Color;
import java.awt.Graphics;

import com.gmail.sigmatheprogrammer.util.KeyHandler;
import com.gmail.sigmatheprogrammer.util.Main;
import com.gmail.sigmatheprogrammer.util.MouseHandler;

public class Play implements State {
	public Play() {
		
	}
	public void update() {
		
	}
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, Main.width, Main.height);
	}
	public void processInput(MouseHandler m,KeyHandler k) {
		
	}
}
