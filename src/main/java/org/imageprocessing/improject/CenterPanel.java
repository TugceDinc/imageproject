package org.imageprocessing.improject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.AbstractAction;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import org.imageprocessing.improject.programproperties.ProgramColor;

public class CenterPanel extends JPanel {

	ImagePanel pnlImage;
	JPanel pnlCoordinates;
	JLabel lbCoordinates;
	Dimension currentBounds;



	/**
	 * Create the panel.
	 */
	public CenterPanel() {
		this.setBackground(new Color(255, 255, 255));
		this.currentBounds = this.getSize();
		JScrollPane scrollPane = new JScrollPane(this);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(50, 30, 300, 50);



		ProgramColor color = ProgramColor.getColor();
		setLayout(null);
		pnlImage = new ImagePanel();
		pnlImage.setBackground(new Color(255, 255, 255));
		this.add(pnlImage);

		pnlCoordinates = new JPanel(new BorderLayout());
		pnlCoordinates.setBackground(color.clrBackground);
		pnlCoordinates.setBounds(0, this.getHeight()-20, this.getWidth(), 20);

		this.add(pnlCoordinates);

		lbCoordinates =new JLabel();
		lbCoordinates.setForeground(color.clrForeColor);
		pnlCoordinates.add(lbCoordinates,BorderLayout.EAST);

		pnlImage.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				setCoordinateValues(e.getPoint());
			}
		});

	}

	@Override
	public void printComponents(Graphics g) {
		super.printComponents(g);
//		pnlImage.setBounds(this.getWidth() / 2 - pnlImage.getWidth() / 2,
//				this.getHeight() / 2 - pnlImage.getHeight() / 2, pnlImage.getWidth(), pnlImage.getHeight());
		pnlCoordinates.setBounds(0, this.getHeight()-20, this.getWidth(), 20);

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(!currentBounds.equals(this.getSize())) {
			pnlImage.setBounds(0, 0,this.getWidth(), this.getHeight() - 20);
			pnlCoordinates.setBounds(0, this.getHeight()-20, this.getWidth(), 20);
			currentBounds = this.getSize();

		}
	}

	public void setCoordinateValues(Point point) {
		this.lbCoordinates.setText("X : " + point.x +" Y : " + point.y);
	}

}
