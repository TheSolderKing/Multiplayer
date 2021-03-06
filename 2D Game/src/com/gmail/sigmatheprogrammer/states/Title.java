package com.gmail.sigmatheprogrammer.states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.gmail.sigmatheprogrammer.util.Button;
import com.gmail.sigmatheprogrammer.util.KeyHandler;
import com.gmail.sigmatheprogrammer.util.Main;
import com.gmail.sigmatheprogrammer.util.MouseHandler;

public class Title implements State {
	public Main main;
	private Button b;

		
	public Title(Main m) {
		main = m;
		System.out.println(Main.width);
		try{
		b  = new Button(Main.width/2-100, Main.height/2-50, 200, 100, ImageIO.read(new File("Untitled.png")));
		} catch(IOException e) {
			
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Main.width, Main.height);
		g.setColor(Color.YELLOW);
		b.render(g);
	}
	
	public void update() {
		if(b.isPressed()) {
			main.setState(new Play());
		}
	}
	public void processInput(MouseHandler m,KeyHandler k) {
		b.processInput(m);
		if(k.keyDown(KeyEvent.VK_SPACE)) {
			main.setState(new Play());
		}
	}
}
