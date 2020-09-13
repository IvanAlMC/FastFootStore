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

public class JPanelNorthAdmin extends JPanel {

	private static final long serialVersionUID = 1L;

	public static final int WIDTH_SCREEN = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	public static final int HEIGHT_SCREEN = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	private JButtonsMenuAndDialogs list, create, delete, clientsToAttend, clientsAttended, sales, attend;
	private IconLabel icon;
	private JPanelBody body;

	public JPanelNorthAdmin(ActionListener actionListener) {
		setBackground(Color.BLACK);
		setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		initComponents(actionListener);
		setVisible(true);
	
	}

	public void initComponents(ActionListener actionListener) {
		icon = new IconLabel(200, 60);
		icon.setBackground(Color.BLACK);
		icon.setText(MyMessage.WELCOME);
		icon.setFont(new Font(MyMessage.FONT_RUBIK, Font.BOLD, 20));
		icon.setFocusable(false);
		icon.setVerticalTextPosition(SwingConstants.CENTER);
		icon.setHorizontalTextPosition(SwingConstants.LEFT);
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(WIDTH_SCREEN - 25, 80));
		panel.setBackground(Color.BLACK);
		panel.add(icon);
		add(panel, BorderLayout.NORTH);
		list = new JButtonsMenuAndDialogs(MyMessage.MENU_PRODUCTS, MyMessage.MENU_PATH, actionListener, Actions.SHOW_LIST);
		add(list);
		create = new JButtonsMenuAndDialogs(MyMessage.ADD_PRODUCT, MyMessage.ADD_PATH, actionListener,Actions.CREATE_PRODUCT);
		add(create);
		delete = new JButtonsMenuAndDialogs(MyMessage.DELETE_PRODUCT, MyMessage.DELETE_PATH, actionListener, Actions.DELETE_PRODUCT_MENU);
		add(delete);
		clientsToAttend = new JButtonsMenuAndDialogs(MyMessage.CLIENTS_TO_ATTEND, MyMessage.TIME_PATH, actionListener, Actions.CLIENTS_TO_ATTEND);
		add(clientsToAttend);
		clientsAttended = new JButtonsMenuAndDialogs(MyMessage.CLIENTS_ATTEND, MyMessage.FINE_PATH, actionListener, Actions.CLIENTS_ATTENDED);
		add(clientsAttended);
		sales = new JButtonsMenuAndDialogs(MyMessage.TOTAL_SALES, MyMessage.SALE_PATH, actionListener, Actions.SALES);
		add(sales);
		attend = new JButtonsMenuAndDialogs(MyMessage.ATTEND_CLIENT, MyMessage.ATTEND_PATH, actionListener, Actions.ATTEND);
		add(attend);
		body = new JPanelBody();
		body.setPreferredSize(new Dimension(WIDTH_SCREEN-25, HEIGHT_SCREEN-280));
		this.add(body, BorderLayout.CENTER);
		body.setVisible(true);
	}

}
