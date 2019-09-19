package org.imageprocessing.improject.programproperties;

import java.awt.Color;

public abstract class ProgramColor {
	static protected ProgramColor color;
	public Color clrBackground;
	public Color clrFrond;
	public Color clrForeColor;	
	
	public static ProgramColor getColor() {
		return color;
	}

}
