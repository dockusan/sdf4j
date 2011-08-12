package org.sdf4j.core;

public class Color {

	public final static Color white = new Color(255, 255, 255);
	public final static Color WHITE = white;
	public final static Color lightGray = new Color(192, 192, 192);
	public final static Color LIGHT_GRAY = lightGray;
	public final static Color gray = new Color(128, 128, 128);
	public final static Color GRAY = gray;
	public final static Color darkGray = new Color(64, 64, 64);
	public final static Color DARK_GRAY = darkGray;
	public final static Color black = new Color(0, 0, 0);
	public final static Color BLACK = black;
	public final static Color red = new Color(255, 0, 0);
	public final static Color RED = red;
	public final static Color pink = new Color(255, 175, 175);
	public final static Color PINK = pink;
	public final static Color orange = new Color(255, 200, 0);
	public final static Color ORANGE = orange;
	public final static Color yellow = new Color(255, 255, 0);
	public final static Color YELLOW = yellow;
	public final static Color green = new Color(0, 255, 0);
	public final static Color GREEN = green;
	public final static Color magenta = new Color(255, 0, 255);
	public final static Color MAGENTA = magenta;
	public final static Color cyan = new Color(0, 255, 255);
	public final static Color CYAN = cyan;
	public final static Color blue = new Color(0, 0, 255);
	public final static Color BLUE = blue;

	private static final double FACTOR = 0.7;

	private int value;

	public Color(int r, int g, int b) {
		this(r, g, b, 255);
	}

	public Color(int r, int g, int b, int a) {
		value = ((a & 0xFF) << 24) | ((r & 0xFF) << 16) | ((g & 0xFF) << 8) | ((b & 0xFF) << 0);
	}

	public Color(int rgb) {
		value = 0xFF000000 | rgb;
	}

	public int getRed() {
		return (getRGB() >> 16) & 0xFF;
	}

	public int getGreen() {
		return (getRGB() >> 8) & 0xFF;
	}

	public int getBlue() {
		return (getRGB() >> 0) & 0xFF;
	}

	public int getAlpha() {
		return (getRGB() >> 24) & 0xFF;
	}

	public int getRGB() {
		return value;
	}

	public Color brighter() {
		int r = getRed();
		int g = getGreen();
		int b = getBlue();

		/*
		 * From 2D group: 1. black.brighter() should return grey 2. applying
		 * brighter to blue will always return blue, brighter 3. non pure color
		 * (non zero rgb) will eventually return white
		 */
		int i = (int) (1.0 / (1.0 - FACTOR));
		if (r == 0 && g == 0 && b == 0) {
			return new Color(i, i, i);
		}
		if (r > 0 && r < i)
			r = i;
		if (g > 0 && g < i)
			g = i;
		if (b > 0 && b < i)
			b = i;

		return new Color(Math.min((int) (r / FACTOR), 255), Math.min((int) (g / FACTOR), 255), Math
				.min((int) (b / FACTOR), 255));
	}

	public Color darker() {
		return new Color(Math.max((int) (getRed() * FACTOR), 0), Math.max(
				(int) (getGreen() * FACTOR), 0), Math.max((int) (getBlue() * FACTOR), 0));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Color other = (Color) obj;
		if (value != other.value)
			return false;
		return true;
	}
}
