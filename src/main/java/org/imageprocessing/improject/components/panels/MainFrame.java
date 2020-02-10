package org.imageprocessing.improject.components.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ColorModel;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import javax.swing.plaf.metal.MetalSplitPaneUI;
import javax.swing.text.AttributeSet.ColorAttribute;

import org.imageprocessing.improject.programproperties.ImageManager;
import org.imageprocessing.improject.programproperties.ProgramColor;
import org.imageprocessing.improject.programproperties.ProgramColorFactory;
import org.imageprocessing.improject.programproperties.ProgramColorTypes;

import javax.swing.JSplitPane;

public class MainFrame extends JFrame {
	private JPanel contentPane;

	private ProgramColor colors;

	private JPanel pnlTop;
	private JPanel pnlCenter;
	private JPanel pnlCenterRight;
	private JPanel pnlCenterLeft;
	private JPanel pnlCenterCenter;

	private JSplitPane sp1;
	private JSplitPane sp2;
	ImageManager imgManager;

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		colors = ProgramColorFactory.factory(ProgramColorTypes.Dark);
		init();	
	}

	private void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1938, 1038);
		this.setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH );
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(4, 4, 4, 4));
		contentPane.setLayout(new BorderLayout(4, 4));
		contentPane.setMinimumSize(getMaximumSize());
		setContentPane(contentPane);
		contentPane.setBackground(colors.clrBackground);

		initPanels();

		addPanelsToSplitPanes(pnlCenterLeft, pnlCenterCenter, pnlCenterRight);
		


		
		
		
		JMenuBar menuBar = new ProgramMenuBar(imgManager);

		this.setJMenuBar(menuBar);


		JPanel pnlToolBar = new JPanel();
		//add toolbars here
		pnlToolBar.setBackground(colors.clrFrond);
		pnlToolBar.setLayout(null);
		pnlToolBar.setPreferredSize(pnlTop.getSize());
		pnlTop.add(pnlToolBar, BorderLayout.CENTER);
	}


	private void initPanels() {
		
		
		imgManager = new ImageManager();		
		
		pnlTop = new JPanel();
		contentPane.add(pnlTop, BorderLayout.NORTH);
		//pnlTop.setLayout(null);
		pnlTop.setLayout(new BorderLayout(0, 0));
		pnlTop.setBackground(colors.clrFrond);
		pnlTop.setPreferredSize(new Dimension(0,50));

		pnlCenter = new JPanel();
		contentPane.add(pnlCenter, BorderLayout.CENTER);
		pnlCenter.setBackground(colors.clrBackground);
		pnlCenter.setLayout(new BorderLayout(4, 4));
		pnlCenter.setBorder(new EmptyBorder(4,4,4,4));

		pnlCenterRight = new JPanel(new GridLayout());
		pnlCenterRight.setPreferredSize(new Dimension(300, 0));
		pnlCenterRight.setMinimumSize(new Dimension(300, 0));
		pnlCenterRight.setBackground(colors.clrFrond);

		pnlCenterLeft = new JPanel(new BorderLayout(0, 0)) {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.fillRoundRect(this.getX(), this.getY(), getWidth(), getHeight(), 15, 15);
				g.drawRoundRect(this.getX(), this.getY(), getWidth(), getHeight(), 15, 15);
			}
		};
		pnlCenterLeft.setPreferredSize(new Dimension(300, 0));
		pnlCenterLeft.setMinimumSize(new Dimension(300, 0));
		pnlCenterLeft.setBackground(colors.clrFrond);
		
		
		
		
		JPanel pnlTools = new ToolPanel(imgManager);
		pnlCenterLeft.add(pnlTools, BorderLayout.NORTH);

		

		pnlCenterCenter = new CenterPanel(imgManager);

	}

	private void addPanelsToSplitPanes(JPanel pnl1, JPanel pnl2, JPanel pnl3){
		sp1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnl1, pnl2);
		sp1.setUI(new BasicSplitPaneUI() {
			@Override
			public BasicSplitPaneDivider createDefaultDivider() {
				return new BasicSplitPaneDivider(this) {                
					public void setBorder(Border b) {}

					@Override
					public void paint(Graphics g) {
						g.setColor(colors.clrBackground);
						g.fillRect(0, 0, getSize().width, getSize().height);
						super.paint(g);
					}
				};
			}
		});
		sp1.setBackground(colors.clrFrond);
		sp1.setBorder(null);

		sp2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sp1, pnl3);
		sp2.setBackground(colors.clrFrond);
		sp2.setUI(new BasicSplitPaneUI() {
			@Override
			public BasicSplitPaneDivider createDefaultDivider() {
				return new BasicSplitPaneDivider(this) {                
					public void setBorder(Border b) {}

					@Override
					public void paint(Graphics g) {
						g.setColor(colors.clrBackground);
						g.fillRect(0, 0, getSize().width, getSize().height);
						super.paint(g);
					}
				};
			}
		});		
		sp2.setBorder(null);
		sp2.setResizeWeight(1);

		sp1.setDividerSize(5);
		sp2.setDividerSize(5);
		sp1.setBackground(colors.clrBackground);
		sp2.setBackground(colors.clrBackground);

		pnlCenter.add(sp2);
	}	

}