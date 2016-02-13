package com.gmail.sigmatheprogrammer.util;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler {
	boolean keys[] = new boolean[256];
	KeyListener klis  = new KeyListener() {

		@Override
		public void keyTyped(KeyEvent e) {
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			keys[e.getKeyCode()] = true;
		}

		@Override
		public void keyReleased(KeyEvent e) {
			keys[e.getKeyCode()] = false;
		}
		
	};
	public KeyHandler() {
	}
	public boolean keyDown(int num) {
		return keys[num];
	}
	public KeyListener getKeyListener() {
		return klis;
	}
}
