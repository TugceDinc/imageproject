package org.imageprocessing.improject.programproperties;

public class ProgramColorFactory {
	public static ProgramColor factory(ProgramColorTypes type){
		switch (type) {
		case Dark:
			 
			return BlackProgramColor.getInstance();
		default:
			return null;
		}	
	}
	
}
