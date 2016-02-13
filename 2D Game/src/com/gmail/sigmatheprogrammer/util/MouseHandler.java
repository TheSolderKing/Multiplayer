package com.gmail.sigmatheprogrammer.util;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseHandler {
	boolean pressed = false;
	int x;
	int y;
	MouseListener mlis = new MouseListener() {
		@Override
		public void mouseClicked(MouseEvent e) {
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			pressed = true;
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			pressed = false;
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
		}
	};
	MouseMotionListener mmlis = new MouseMotionListener() {

		@Override
		public void mouseDragged(MouseEvent e) {
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			x = e.getX();
			y = e.getY();
		}
		
	};
	
	public MouseHandler() {
		
	}
	public boolean mousePressed() {
		return pressed;
	}
	public int getMouseX() {
		return x;
	}
	public int getMouseY() {
		return y;
	}
	public MouseListener getMouseListener() {
		return mlis;
	}
	public MouseMotionListener getMouseMotionListener() {
		return mmlis;
	}
	
}
