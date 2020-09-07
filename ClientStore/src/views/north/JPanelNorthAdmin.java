package views.north;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controllers.Commands;
import views.IconLabel;
import views.JButtonsMenuAndDialogs;
import views.MyMessage;

public class JPanelNorthAdmin extends JPanel {

	private static final long serialVersionUID = 1L;

	public static final int WIDTH_SCREEN = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	public static final int HEIGHT_SCREEN = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	private JButtonsMenuAndDialogs list, create, delete, clientsToAttend, clientsAttended, sales, attend;
	private IconLabel icon;

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
		list = new JButtonsMenuAndDialogs(MyMessage.MENU_PRODUCTS, MyMessage.MENU_PATH);
		list.addActionListener(actionListener);
		list.setActionCommand(Commands.SHOW_LIST.toString());
		add(list);
		create = new JButtonsMenuAndDialogs(MyMessage.ADD_PRODUCT, MyMessage.ADD_PATH);
		create.addActionListener(actionListener);
		create.setActionCommand(Commands.CREATE_PRODUCT.toString());
		add(create);
		delete = new JButtonsMenuAndDialogs(MyMessage.DELETE_PRODUCT, MyMessage.DELETE_PATH);
		delete.addActionListener(actionListener);
		delete.setActionCommand(Commands.DELETE_PRODUCT_ADMIN.toString());
		add(delete);
		clientsToAttend = new JButtonsMenuAndDialogs(MyMessage.CLIENTS_TO_ATTEND, MyMessage.TIME_PATH);
		clientsToAttend.addActionListener(actionListener);
		clientsToAttend.setActionCommand(Commands.SHOW_CLIENTS_TO_ATTEND.toString());
		add(clientsToAttend);
		clientsAttended = new JButtonsMenuAndDialogs(MyMessage.CLIENTS_ATTEND, MyMessage.FINE_PATH);
		clientsAttended.addActionListener(actionListener);
		clientsAttended.setActionCommand(Commands.SHOW_CLIENTS_ATTEND.toString());
		add(clientsAttended);
		sales = new JButtonsMenuAndDialogs(MyMessage.TOTAL_SALES, MyMessage.SALE_PATH);
		sales.addActionListener(actionListener);
		sales.setActionCommand(Commands.SHOW_TOTAL_SALES.toString());
		add(sales);
		attend = new JButtonsMenuAndDialogs(MyMessage.ATTEND_CLIENT, MyMessage.ATTEND_PATH);
		attend.addActionListener(actionListener);
		attend.setActionCommand(Commands.ATTEND_CLIENT.toString());
		add(attend);

	}

}
