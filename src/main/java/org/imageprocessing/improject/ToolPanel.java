package org.imageprocessing.improject;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import org.imageprocessing.improject.mouseproperties.draw.MouseListeners;
import org.imageprocessing.improject.programproperties.ProgramColor;


public class ToolPanel extends JPanel {

	final MouseListeners mouseListeners = new MouseListeners() {

		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		public void mouseDragged(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		public void mouseMoved(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		public void paint(Graphics g) {
			// TODO Auto-generated method stub

		}

	};



	/**
	 * Create the panel.
	 */
	public ToolPanel() {
		init();
	}

	private void init(){ 
		ProgramColor color = ProgramColor.getColor();		
		setBorder(null);
		setBackground(color.clrFrond);
		JButton btnDistance = new JButton();
		//btnDistance.setIcon(new ImageIcon(ToolPanel.class.getResource("/icon/32x32/spacing.png")));
		btnDistance.setBackground(color.clrFrond);
		btnDistance.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}

		});
		btnDistance.setPreferredSize(new Dimension(32, 32));
		btnDistance.setBorder(null);
		this.add(btnDistance);
	}

}