package org.imageprocessing.improject.components.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import org.imageprocessing.improject.programproperties.ImageManager;

public class ProgramMenuBar extends JMenuBar {
	
	
	ImageManager imageManager;
	
	public ProgramMenuBar(ImageManager imageManager) {
		this.imageManager = imageManager;
		init();
	}
	
	private void init() {
		JMenu mFile = new JMenu("File");
		JMenuItem miImport = new JMenuItem("Open");
		miImport.addActionListener(new ActionListener() {
			final JFileChooser  fChooser = new JFileChooser();
			public void actionPerformed(ActionEvent ae) {
				try {
					fChooser.showOpenDialog(null);
					if(fChooser.getSelectedFile() != null){
						File file = fChooser.getSelectedFile();
						if(file.canRead()) {
							imageManager.setImage(ImageIO.read(file));
						}
						else {
							System.out.println("okunamadi");
						}
					}
					
				} catch (Exception e) {
					System.out.println("okunamadi");
				}


			}
		});
		mFile.add(miImport);
		
		
		add(mFile);
	}
	
}
