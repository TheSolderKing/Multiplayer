package com.gmail.sigmatheprogrammer.util;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

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
		System.out.println("process");
		int mx = mh.getMouseX();
		int my = mh.getMouseY();
		if(mh.mousePressed()) {
			pressed = true;
			System.out.println("Pressed");
		} else {
			pressed = false;
		}
	}
	public boolean isPressed() {
		return pressed;
	}
}
