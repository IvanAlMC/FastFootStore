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
import javax.swing.JTextField;

import controllers.Actions;
import views.JButtonsMenuAndDialogs;
import views.JTextFieldDialog;
import views.MyJFramePpal;
import views.MyMessage;

public class JDialogDeleteMenu extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextFieldDialog productName;
	private JButtonsMenuAndDialogs buttonDelete, buttonCancel;

	public JDialogDeleteMenu(MyJFramePpal frame, ActionListener actionListener) {
		setMinimumSize(new Dimension(350, 250));
		getContentPane().setBackground(new Color(40, 40, 40));
		setBackground(new Color(35, 35, 35));
		setIconImage(new ImageIcon(MyMessage.DELETE_PATH).getImage());
		setLocationRelativeTo(frame);
		setTitle(MyMessage.DELETE_PRODUCT);
		getRootPane().setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		setModal(true);
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		addTextField();
		addButtonsDelete(actionListener);
	}

	private void addTextField() {
		Panel panel = new Panel();
		panel.setPreferredSize(new Dimension(340, 130));
		productName = new JTextFieldDialog(MyMessage.IN_NAME_PRODUCT);
		productName.setForeground(Color.WHITE);
		productName.setFont(new Font(MyMessage.FONT_RUBIK, Font.ITALIC, 18));
		productName.setHorizontalAlignment(JTextField.RIGHT);
		productName.setBackground(new Color(90, 90, 90));
		productName.setPreferredSize(new Dimension(250, 50));
		panel.add(productName);
		add(panel);
	}

	private void addButtonsDelete(ActionListener actionListenner) {
		JPanel panelButtons = createPanel(10);
		panelButtons.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
		buttonDelete = new JButtonsMenuAndDialogs(MyMessage.DELETE, 120, 35, actionListenner, Actions.ACCEPT_ERASE);
		buttonDelete.setFont(new Font(MyMessage.FONT_RUBIK, Font.BOLD, 14));
		buttonDelete.setBackground(Color.RED);
		buttonDelete.setForeground(Color.WHITE);
		panelButtons.add(buttonDelete);
		buttonCancel = new JButtonsMenuAndDialogs(MyMessage.CANCEL, 120, 35, actionListenner, Actions.CANCEL_ERASE);
		buttonCancel.setFont(new Font(MyMessage.FONT_RUBIK, Font.BOLD, 14));
		buttonCancel.setBackground(Color.orange);
		buttonCancel.setForeground(Color.WHITE);
		panelButtons.add(buttonCancel);
		add(panelButtons);
	}

	private JPanel createPanel(int separation) {
		JPanel panel = new JPanel();
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
		layout.setHgap(separation);
		panel.setLayout(layout);
		panel.setOpaque(false);
		return panel;
	}

	public void clearComponents() {
		productName.setText("");
	}

	public String getNameProduct() {
		return productName.getText();
	}
}
