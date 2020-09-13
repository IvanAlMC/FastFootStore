package views.north;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controllers.Actions;
import views.IconLabel;
import views.JButtonsMenuAndDialogs;
import views.MyMessage;
import views.body.JPanelBody;

public class JPanelNorthClient extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH_SCREEN = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	public static final int HEIGHT_SCREEN = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	private JButtonsMenuAndDialogs register, list, add, delete, bill,time, turn;
	private IconLabel icon;
	private JPanelBody body;
	
	public JPanelNorthClient(ActionListener actionListener) {
		setBackground(Color.BLACK);
    	setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		initComponents(actionListener);
		setVisible(true);
	}
	
	public void initComponents(ActionListener actionListener) {
		icon = new IconLabel(200,60);
		icon.setBackground(Color.BLACK);
		icon.setText(MyMessage.WELCOME);
		icon.setFont(new Font(MyMessage.FONT_RUBIK, Font.BOLD, 20));
		icon.setFocusable(false);
		icon.setVerticalTextPosition(SwingConstants.CENTER);
		icon.setHorizontalTextPosition(SwingConstants.LEFT);
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(WIDTH_SCREEN-25, 80));
		panel.setBackground(Color.BLACK);
		panel.add(icon);
		add(panel, BorderLayout.NORTH);
		register = new JButtonsMenuAndDialogs(MyMessage.REGISTER, MyMessage.REGISTER_PATH, actionListener, Actions.REGISTER);
    	add(register);
		list = new JButtonsMenuAndDialogs(MyMessage.MENU_PRODUCTS, MyMessage.MENU_PATH, actionListener, Actions.SHOW_LIST);
    	add(list);
    	add = new JButtonsMenuAndDialogs(MyMessage.ADD_PRODUCT, MyMessage.ADD_PATH, actionListener, Actions.ADD_PRODUCT);
    	add(add);
    	delete = new JButtonsMenuAndDialogs(MyMessage.DELETE_PRODUCT, MyMessage.DELETE_PATH, actionListener, Actions.DELETE_PRODUCT);
    	add(delete);
    	bill = new JButtonsMenuAndDialogs(MyMessage.SEE_BILL, MyMessage.BILL_PATH, actionListener, Actions.BILL);
    	add(bill);
    	turn = new JButtonsMenuAndDialogs(MyMessage.SEE_TURN, MyMessage.TURN_PATH, actionListener, Actions.TURN);
    	add(turn);
    	time = new JButtonsMenuAndDialogs(MyMessage.SEE_TIME, MyMessage.TIME_PATH, actionListener, Actions.TIME);
    	add(time);
    	body = new JPanelBody();
		body.setPreferredSize(new Dimension(WIDTH_SCREEN-25, HEIGHT_SCREEN-280));
		this.add(body, BorderLayout.CENTER);
		body.setVisible(true);
	}

}
