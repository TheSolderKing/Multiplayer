package com.gmail.sigmatheprogrammer.util;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.gmail.sigmatheprogrammer.states.State;
import com.gmail.sigmatheprogrammer.states.Title;

public class Main {
	// Set the milliseconds of delay between updates
	private static final double MS_PER_UPDATE = 100;
	// Set the previous time and lag values
	double previous = getCurrentTime();
	double lag = 0.0;
	Graphics g;
	JFrame a = new JFrame();
	Canvas c = new Canvas();
	JButton exit = new JButton();
	BufferStrategy buffer;
	MouseHandler mhandler = new MouseHandler();
	KeyHandler khandler = new KeyHandler();
	public static int width, height;
	public boolean running = true;	
	public State state = new Title(this);
	
	public static void main(String[] args) {
		new Main(); // Begin
	}

	

	public Main() {
		// Do initial JFrame stuffs
		a.setTitle("Chilly Bass");
		a.setIgnoreRepaint(true);
		a.setExtendedState(JFrame.MAXIMIZED_BOTH);
		a.setUndecorated(true);
		c.addMouseListener(mhandler.getMouseListener());
		c.addMouseMotionListener(mhandler.getMouseMotionListener());
		c.addKeyListener(khandler.getKeyListener());
		c.setIgnoreRepaint(true);
		
		exit.setBackground(Color.RED);
		exit.setBounds(0,0,50,50);
		exit.setText("X");
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				stop();
			}
		});
		a.add(exit);
		// Add the canvas to the frame
		a.add(c);
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		a.setVisible(true); // Show the frame
		width = a.getWidth();
		height = a.getHeight();
		// Begin the buffer
		c.createBufferStrategy(2);
		buffer = c.getBufferStrategy();
		
		
		while (running) {
			// Set current and elapsed times based on values
			double current = getCurrentTime();
			double elapsed = current - previous;
			previous = current;
			// Update lag
			lag += elapsed;
			processInput();
			while (lag >= MS_PER_UPDATE) {
				update(); // perform game updates until caught up
				lag -= MS_PER_UPDATE;
			}
			// Squeeze in a rendering cycle whenever possible
			render(lag/MS_PER_UPDATE);
		}
	}

	private void render(double d) {
		try {
			// Get graphics context
			g = buffer.getDrawGraphics();
			// Do your drawing here:
			state.render(g);
			if (!buffer.contentsLost())
				// If there is a buffer, draw it
				buffer.show();
			// Give the CPU a break
			//Thread.yield();
		} finally {
			if (g != null)
				// Throw away the graphics context :(
				g.dispose();
		}
	}

	private void update() {
		state.update();
	}

	private void processInput() {
		state.processInput(mhandler,khandler);
	}

	private double getCurrentTime() {
		// Not sure why I even have this here
		return System.currentTimeMillis();
	}
	
	public void setState(State s) {
		state = s;
	}
	public void stop() {
		running = false;
		Thread.yield();
		a.dispatchEvent(new WindowEvent(a,WindowEvent.WINDOW_CLOSING));
	}
}
