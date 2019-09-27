package org.imageprocessing.improject.components.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

import org.imageprocessing.improject.mouseproperties.ZoomAndDragListener;
import org.imageprocessing.improject.mouseproperties.draw.DrawingLine;
import org.imageprocessing.improject.mouseproperties.draw.MouseListeners;
import org.imageprocessing.improject.programproperties.ImageManager;
import org.imageprocessing.improject.programproperties.ProgramColor;


public class ToolPanel extends JPanel {

	MouseListeners mouseListeners;

	ImageManager imgmngr;
	
	ProgramColor color;
	/**
	 * Create the panel.
	 */
	public ToolPanel(ImageManager imgmngr) {
		this.imgmngr = imgmngr;
		init();
	}

	private void init(){ 
		
		mouseListeners = new ZoomAndDragListener(imgmngr);
		imgmngr.getImgpanel().addMouseListeners(mouseListeners);
		
		
		color = ProgramColor.getColor();		
		setBorder(null);
		setBackground(color.clrFrond);
		
		ImageIcon iconLine = new ImageIcon(ToolPanel.class.getResource("/icon/32x32/Line.png"));
		JButton btnLine = this.createBttn(iconLine);
		btnLine.addActionListener(new ActionListener() {

			DrawingLine listener = new DrawingLine(imgmngr);
			
			public void actionPerformed(ActionEvent arg0) {
				imgmngr.getImgpanel().removeMouseListeners(mouseListeners);
				mouseListeners = listener;
				imgmngr.getImgpanel().addMouseListeners(mouseListeners);
			}

		});
		this.add(btnLine);

		ImageIcon iconPan = new ImageIcon(ToolPanel.class.getResource("/icon/32x32/Cursor.png"));
		JButton btnPan = this.createBttn(iconPan);
		btnPan.addActionListener(new ActionListener() {
			ZoomAndDragListener listener = new ZoomAndDragListener(imgmngr);
			
			@Override
			public void actionPerformed(ActionEvent e) {
				imgmngr.getImgpanel().removeMouseListeners(mouseListeners);
				mouseListeners = listener;
				imgmngr.getImgpanel().addMouseListeners(mouseListeners);
			}
		});
		this.add(btnPan);
		
		ImageIcon iconColor = new ImageIcon(ToolPanel.class.getResource("/icon/32x32/Color.png"));
		JButton btnColor = createBttn(iconColor);
		btnColor.setBackground(imgmngr.getShapeColor());
		btnColor.addActionListener(new ActionListener() {
			JColorChooser chooser = new JColorChooser();
			@Override
			public void actionPerformed(ActionEvent e) {
				Color clr = chooser.showDialog(btnColor.getParent(),"Shape Color", imgmngr.getShapeColor());
				imgmngr.setShapeColor(clr);
				btnColor.setBackground(clr);
				
			}
		});
		this.add(btnColor);
				
	}

	private JButton createBttn(ImageIcon icon) {
		JButton btn = new JButton();
		btn.setIcon(icon);
		btn.setBackground(color.clrFrond);
		btn.setPreferredSize(new Dimension(32, 32));
		btn.setBorder(BorderFactory.createEtchedBorder());
		return btn;
	}
	
	
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.setColor(new Color(200, 200, 200));
	}
	
	
}