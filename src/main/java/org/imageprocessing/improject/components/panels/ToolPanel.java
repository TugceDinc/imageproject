package org.imageprocessing.improject.components.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.border.Border;

import org.imageprocessing.improject.mouseproperties.ZoomAndDragListener;
import org.imageprocessing.improject.mouseproperties.draw.DrawingCenteredCircle;
import org.imageprocessing.improject.mouseproperties.draw.DrawingLine;
import org.imageprocessing.improject.mouseproperties.draw.DrawingSquare;
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
		
		ImageIcon iconsquare = new ImageIcon(ToolPanel.class.getResource("/icon/32x32/rectangle.png"));
		JButton btnsquare = createBttn(iconsquare);
		btnsquare.setBorderPainted(false);
		btnsquare.addActionListener(new ActionListener() {
			DrawingSquare listener = new DrawingSquare(imgmngr);
			@Override
			public void actionPerformed(ActionEvent e) {
				imgmngr.getImgpanel().removeMouseListeners(mouseListeners);
				mouseListeners = listener;
				imgmngr.getImgpanel().addMouseListeners(mouseListeners);
			}
		});
		this.add(btnsquare);
		
		ImageIcon iconLine = new ImageIcon(ToolPanel.class.getResource("/icon/32x32/Line.png"));
		JButton btnLine = this.createBttn(iconLine);
		btnLine.setBorderPainted(false);
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
		btnPan.setBorderPainted(false);
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
		
		ImageIcon iconOval = new ImageIcon(ToolPanel.class.getResource("/icon/32x32/oval.png"));
		JButton btnOval = createBttn(iconOval);
		btnOval.setBorderPainted(false);
		btnOval.addActionListener(new ActionListener() {
			DrawingCenteredCircle listener = new DrawingCenteredCircle(imgmngr);
			
			public void actionPerformed(ActionEvent arg0) {
				imgmngr.getImgpanel().removeMouseListeners(mouseListeners);
				mouseListeners = listener;
				imgmngr.getImgpanel().addMouseListeners(mouseListeners);
			}
		});
		this.add(btnOval);	
		
		ImageIcon iconColor = new ImageIcon(ToolPanel.class.getResource("/icon/32x32/color.png"));
		JButton btnColor = createBttn(iconColor);
		btnColor.setBorderPainted(false);
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
		btn.setPreferredSize(new Dimension(24, 24));
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