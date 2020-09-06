package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import controllers.Commands;

public class JPanelPpal extends JPanel{
	
	public static final int WIDTH_SCREEN = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	public static final int HEIGHT_SCREEN = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;

	
	private static final long serialVersionUID = 1L;
	private JButtonsMenuAndDialogs admin, client;
	private IconLabel icon;

	public JPanelPpal(ActionListener actionListener) {
		setBackground(Color.white);
		setPreferredSize(new Dimension(WIDTH_SCREEN-25, 500));
		FlowLayout flowLayout=new FlowLayout(FlowLayout.CENTER);
		flowLayout.setHgap(30);
		setLayout(flowLayout); 
		initComponents(actionListener);
	}
	
	public void initComponents(ActionListener actionListener) {
		icon = new IconLabel(450,150);
		icon.setBackground(Color.BLACK);
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(WIDTH_SCREEN-25, 200));
		panel.setBackground(Color.WHITE);
		panel.add(icon);
		this.add(panel, BorderLayout.NORTH);
		admin = new JButtonsMenuAndDialogs(MyMessage.ADMIN, MyMessage.ADMIN_PATH, 300);
		admin.addActionListener(actionListener);
    	admin.setActionCommand(Commands.ADMIN.toString());
		this.add(admin);
		client = new JButtonsMenuAndDialogs(MyMessage.CLIENT, MyMessage.CLIENT_PATH, 300);
		client.addActionListener(actionListener);
    	client.setActionCommand(Commands.CLIENT.toString());
		this.add(client);
	}

}
