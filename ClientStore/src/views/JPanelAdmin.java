package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import views.north.JPanelNorthAdmin;

public class JPanelAdmin extends JPanel{

	public static final int WIDTH_SCREEN = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	public static final int HEIGHT_SCREEN = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	
	private static final long serialVersionUID = 1L;
	
	private JPanelNorthAdmin north;
	private int value;
	
	public JPanelAdmin(ActionListener actionListener) {
		value = 2;
		setBackground(Color.white);
		setPreferredSize(new Dimension(WIDTH_SCREEN-25, HEIGHT-20));
		FlowLayout flowLayout=new FlowLayout(FlowLayout.CENTER);
		flowLayout.setHgap(30);
		setLayout(flowLayout); 
		initComponents(actionListener);
	}
	
	public void initComponents(ActionListener actionListener) {
		north = new JPanelNorthAdmin(actionListener);
		north.setPreferredSize(new Dimension(WIDTH_SCREEN, HEIGHT_SCREEN-20));
		this.add(north, BorderLayout.NORTH);
	}
	
	public int getValue() {
		return this.value;
	}

}
