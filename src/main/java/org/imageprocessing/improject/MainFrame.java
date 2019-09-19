package org.imageprocessing.improject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.ColorModel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import javax.swing.plaf.metal.MetalSplitPaneUI;
import javax.swing.text.AttributeSet.ColorAttribute;

import org.imageprocessing.improject.programproperties.ProgramColor;
import org.imageprocessing.improject.programproperties.ProgramColorFactory;
import org.imageprocessing.improject.programproperties.ProgramColorTypes;

import javax.swing.JSplitPane;

public class MainFrame extends JFrame {
	private JPanel contentPane;
	private ProgramColor colors;
	JPanel pnlTop;
	JPanel pnlCenter;
	JPanel pnlCenterRight;
	JPanel pnlCenterLeft;
	JPanel pnlCenterCenter;
	JSplitPane sp1;
	JSplitPane sp2;
	
	
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
		pnlCenterRight.setPreferredSize(new Dimension(400, 0));
		pnlCenterRight.setMinimumSize(new Dimension(400, 0));
		pnlCenterRight.setBackground(colors.clrFrond);

		pnlCenterLeft = new JPanel(new BorderLayout(0, 0));
		pnlCenterLeft.setPreferredSize(new Dimension(400, 0));
		pnlCenterLeft.setMinimumSize(new Dimension(400, 0));
		pnlCenterLeft.setBackground(colors.clrFrond);
		JPanel pnlTools = new ToolPanel();
		pnlCenterLeft.add(pnlTools, BorderLayout.NORTH);		
		
		pnlCenterCenter = new CenterPanel();
		pnlCenterCenter.setBackground(colors.clrFrond);
		

		sp1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnlCenterLeft, pnlCenterCenter);
		sp1.setUI(new BasicSplitPaneUI() 
		{
		    @Override
		    public BasicSplitPaneDivider createDefaultDivider() 
		    {
		        return new BasicSplitPaneDivider(this) 
		        {                
		            public void setBorder(Border b) {}

		            @Override
		            public void paint(Graphics g) 
		            {
		                g.setColor(colors.clrBackground);
		                g.fillRect(0, 0, getSize().width, getSize().height);
		                super.paint(g);
		            }
		        };
		    }
		});
		sp1.setBackground(colors.clrFrond);
		sp1.setBorder(null);
		
		sp2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sp1, pnlCenterRight);
		sp2.setBackground(colors.clrFrond);
		sp2.setUI(new BasicSplitPaneUI() 
		{
		    @Override
		    public BasicSplitPaneDivider createDefaultDivider() 
		    {
		        return new BasicSplitPaneDivider(this) 
		        {                
		            public void setBorder(Border b) {}

		            @Override
		            public void paint(Graphics g) 
		            {
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


		JPanel pnlToolBar = new JPanel();
		//add toolbars here
		pnlToolBar.setBackground(colors.clrFrond);
		pnlToolBar.setLayout(null);
		pnlToolBar.setPreferredSize(pnlTop.getSize());
		pnlTop.add(pnlToolBar, BorderLayout.CENTER);

		JButton btn = new JButton();
		btn.setBounds(0, 0, 32, 32);

		JToolBar menuBar = new JToolBar();
		menuBar.add(btn);
		pnlToolBar.add(menuBar);
	}
}