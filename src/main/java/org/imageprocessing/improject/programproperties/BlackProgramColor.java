package org.imageprocessing.improject.programproperties;

import java.awt.Color;

public class BlackProgramColor extends ProgramColor {
	
	
	public static BlackProgramColor getInstance() {
		if(color == null) {
			color = new BlackProgramColor();
		}
		return (BlackProgramColor)color;
	}
	
	private BlackProgramColor() {
		clrBackground = new Color(75, 75, 75);
		clrFrond = new Color(100, 100, 100);
		clrForeColor =new Color(225, 225, 225);
	}

}
