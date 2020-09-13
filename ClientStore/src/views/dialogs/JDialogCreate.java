package views.dialogs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;

import controllers.Actions;
import views.JButtonsMenuAndDialogs;
import views.JTextFieldDialog;
import views.MyJFramePpal;
import views.MyMessage;

public class JDialogCreate extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextFieldDialog name, price, size, time;
	private JButtonsMenuAndDialogs buttonAccept, buttonCancel;

	public JDialogCreate(MyJFramePpal frame, ActionListener actionListener) {
		setMinimumSize(new Dimension(350, 500));
		setMaximumSize(new Dimension(350, 500));
		getRootPane().setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		setTitle(MyMessage.ADD_PRODUCT);
		setIconImage(new ImageIcon(MyMessage.ADD_PATH).getImage());
		setModal(true);
		setLocationRelativeTo(frame);
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		getContentPane().setBackground(new Color(40, 40, 40));
		setBackground(new Color(35, 35, 35));
		initComponents(actionListener);
	}

	public void initComponents(ActionListener actionListener) {
		Color colorPanel = new Color(40, 40, 40);
		Panel namePanel = new Panel();
		namePanel.setBackground(colorPanel);
		name = new JTextFieldDialog(MyMessage.IN_NAME_PRODUCT);
		namePanel.add(name);
		add(namePanel);
		Panel pricePanel = new Panel();
		pricePanel.setBackground(colorPanel);
		price = new JTextFieldDialog(MyMessage.IN_PRICE);
		pricePanel.add(price);
		add(pricePanel);
		Panel sizePanel = new Panel();
		sizePanel.setBackground(colorPanel);
		size = new JTextFieldDialog(MyMessage.IN_SIZE);
		sizePanel.add(size);
		add(sizePanel);
		Panel timePanel = new Panel();
		timePanel.setBackground(colorPanel);
		time = new JTextFieldDialog(MyMessage.IN_TIME);
		timePanel.add(time);
		add(timePanel);
		addButtons(actionListener);
	}

	private JPanel createPanel(int separation) {
		JPanel panel = new JPanel();
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
		layout.setHgap(separation);
		panel.setLayout(layout);
		panel.setOpaque(false);
		return panel;
	}

	private void addButtons(ActionListener actionListenner) {
		JPanel panelButtons = createPanel(10);
		panelButtons.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
		buttonAccept = new JButtonsMenuAndDialogs(MyMessage.ACCEPT, 120, 60, actionListenner, Actions.ACCEPT_CREATE);
		buttonAccept.setFont(new Font(MyMessage.FONT_RUBIK, Font.BOLD, 14));
		buttonAccept.setBackground(Color.GREEN);
		buttonAccept.setForeground(Color.WHITE);
		panelButtons.add(buttonAccept);
		buttonCancel = new JButtonsMenuAndDialogs(MyMessage.CANCEL, 120, 60, actionListenner, Actions.CANCEL_CREATE);
		buttonCancel.setFont(new Font(MyMessage.FONT_RUBIK, Font.BOLD, 14));
		buttonCancel.setBackground(Color.RED);
		buttonCancel.setForeground(Color.WHITE);
		panelButtons.add(buttonCancel);
		add(panelButtons);
	}

	public void clearComponents() {
		name.setText(MyMessage.EMPTY);
		price.setText(MyMessage.EMPTY);
		size.setText(MyMessage.EMPTY);
		time.setText(MyMessage.EMPTY);
	}
	
	public String getNameProduct() {
		return name.getText();
	}
	
	public double getPrice() {
		return Double.parseDouble(price.getText());
	}
	
	public String getSizeP() {
		return size.getText();
	}
	
	public double getTime() {
		return Double.parseDouble(time.getText());
	}
}
