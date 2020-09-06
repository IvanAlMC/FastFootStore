package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class JPanelClient extends JPanel{
	
	public static final int WIDTH_SCREEN = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	public static final int HEIGHT_SCREEN = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;

	
	private static final long serialVersionUID = 1L;
	private JPanelNorthClient north;

	public JPanelClient(ActionListener actionListener) {
		setBackground(Color.white);
		setPreferredSize(new Dimension(WIDTH_SCREEN-25, 900));
		FlowLayout flowLayout=new FlowLayout(FlowLayout.CENTER);
		flowLayout.setHgap(30);
		setLayout(flowLayout); 
		initComponents(actionListener);
	}
	
	public void initComponents(ActionListener actionListener) {
		north = new JPanelNorthClient(actionListener);
		north.setPreferredSize(new Dimension(WIDTH_SCREEN, 200));
		this.add(north, BorderLayout.NORTH);
	}
}