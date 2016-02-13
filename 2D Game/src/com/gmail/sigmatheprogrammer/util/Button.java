package com.gmail.sigmatheprogrammer.util;

import java.awt.Graphics;
import java.awt.Image;

public class Button {
	int x;
	int y;
	int width;
	int height;
	Image img;
	boolean pressed;
	public Button(int x,int y,int width,int height,Image image) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.img = image;
	}
	public void render(Graphics g) {
		g.drawImage(img, x, y, width, height, null);
	}
	public void processInput(MouseHandler mh) {
		int mx = mh.getMouseX();
		int my = mh.getMouseY();
		if(mx>x && mx<x+width && my>y && my <y+height && mh.mousePressed()) {
			pressed = true;
		} else {
			pressed = false;
		}
	}
}
