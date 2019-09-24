package org.imageprocessing.improject.components.panels;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

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
		
		JMenuItem miSave = new JMenuItem("Save");
		miSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				imageManager.zoomFactor = 1;
				imageManager.xOffset = 0;
				imageManager.yOffset = 0;
				imageManager.getImgpanel().repaint();
				
				int width = imageManager.getImgpanel().getImage().getWidth();
				
				int height = imageManager.getImgpanel().getImage().getHeight();
				
				JPanel pnl = imageManager.getImgpanel();
				
			    BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			    Graphics2D g = bi.createGraphics();
			    pnl.paint(g);
			    pnl.paintImmediately(0, 0, width, height);
			    g.dispose();
			    
			    File outputfile = new File("C:\\Users\\Tugce\\Desktop\\outputimg.jpg");
			    try {
					ImageIO.write(bi, "jpg", outputfile);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mFile.add(miSave);
		
		add(mFile);
	}
	
}
