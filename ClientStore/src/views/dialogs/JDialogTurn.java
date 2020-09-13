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

public class JDialogTurn extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextFieldDialog cc;
	private JButtonsMenuAndDialogs buttonAccept, buttonCancel;

	public JDialogTurn(MyJFramePpal frame, ActionListener actionListener) {
		setMinimumSize(new Dimension(350, 180));
		getContentPane().setBackground(new Color(40, 40, 40));
		setBackground(new Color(35, 35, 35));
		setIconImage(new ImageIcon(MyMessage.TURN_PATH).getImage());
		setLocationRelativeTo(frame);
		setTitle(MyMessage.SEE_TURN);
		getRootPane().setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		setModal(true);
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		addTextField();
		addButtons(actionListener);
	}

	private void addTextField() {
		Panel panel = new Panel();
		panel.setPreferredSize(new Dimension(340, 60));
		cc = new JTextFieldDialog(MyMessage.IN_CC);
		cc.setForeground(Color.WHITE);
		cc.setFont(new Font(MyMessage.FONT_RUBIK, Font.ITALIC, 18));
		cc.setHorizontalAlignment(JTextField.RIGHT);
		cc.setBackground(new Color(90, 90, 90));
		cc.setPreferredSize(new Dimension(250, 50));
		panel.add(cc);
		add(panel);
	}

	private void addButtons(ActionListener actionListenner) {
		JPanel panelButtons = createPanel(10);
		panelButtons.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
		buttonAccept = new JButtonsMenuAndDialogs(MyMessage.ACCEPT, 120, 35, actionListenner, Actions.ACCEPT_CC_TURN);
		buttonAccept.setFont(new Font(MyMessage.FONT_RUBIK, Font.BOLD, 14));
		buttonAccept.setBackground(Color.GREEN);
		buttonAccept.setForeground(Color.WHITE);
		panelButtons.add(buttonAccept);
		buttonCancel = new JButtonsMenuAndDialogs(MyMessage.CANCEL, 120, 35, actionListenner, Actions.CANCEL_CC_TURN);
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
		cc.setText("");
	}
	
	public int getCC() {
		return Integer.parseInt(cc.getText());
	}

}
