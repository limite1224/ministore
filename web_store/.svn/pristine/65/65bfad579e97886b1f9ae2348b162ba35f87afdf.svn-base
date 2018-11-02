package com.leshun.plc.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

public final class ImageUtil {
	private static final int LINES = 8;
	private static final int WIDTH = 128;
	private static final int HEIGHT = 40;
	private static final int FONT_SIZE = 26;

	public static void createImage(String mes, OutputStream os) {
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
				BufferedImage.TYPE_INT_RGB);
		Graphics graphic = image.getGraphics();
		graphic.setColor(Color.LIGHT_GRAY);
		graphic.fillRect(0, 0, WIDTH, HEIGHT);
		Random ran = new Random();
		graphic.setColor(Color.blue);
		graphic.setFont(new Font(null, Font.BOLD + Font.ITALIC, FONT_SIZE));
		graphic.drawString(mes, 0, HEIGHT - 5);
		// 画干扰线
		for (int i = 1; i <= LINES; i++) {
			graphic.setColor(getRandomColor());
			graphic.drawLine(ran.nextInt(WIDTH), ran.nextInt(HEIGHT),
					ran.nextInt(WIDTH), ran.nextInt(HEIGHT));
		}
		try {
			// 输出图像到页面
			ImageIO.write(image, "JPEG", os);
		} catch (IOException e) {
		}
	}

	public static Color getRandomColor() {
		Random ran = new Random();
		Color color = new Color(ran.nextInt(256), ran.nextInt(256),
				ran.nextInt(256));
		return color;
	}

}
