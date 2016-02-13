package com.gmail.sigmatheprogrammer.states;

import java.awt.Graphics;

import com.gmail.sigmatheprogrammer.util.KeyHandler;
import com.gmail.sigmatheprogrammer.util.MouseHandler;

public interface State {
	public void render(Graphics g);
	public void update();
	public void processInput(MouseHandler m,KeyHandler k);
}
