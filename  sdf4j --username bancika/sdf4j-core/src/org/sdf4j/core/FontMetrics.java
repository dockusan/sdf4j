package org.sdf4j.core;

import java.io.Serializable;

public class FontMetrics implements Serializable {

	private static final long serialVersionUID = 1L;

	private int ascent;
	private int descent;
	private int leading;

	public FontMetrics(int ascent, int descent, int leading) {
		super();
		this.ascent = ascent;
		this.descent = descent;
		this.leading = leading;
	}

	public int getAscent() {
		return ascent;
	}

	public void setAscent(int ascent) {
		this.ascent = ascent;
	}

	public int getDescent() {
		return descent;
	}

	public void setDescent(int descent) {
		this.descent = descent;
	}

	public int getLeading() {
		return leading;
	}

	public void setLeading(int leading) {
		this.leading = leading;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ascent;
		result = prime * result + descent;
		result = prime * result + leading;
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
		FontMetrics other = (FontMetrics) obj;
		if (ascent != other.ascent)
			return false;
		if (descent != other.descent)
			return false;
		if (leading != other.leading)
			return false;
		return true;
	}
}
