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

import controllers.Commands;
import views.JButtonsMenuAndDialogs;
import views.JTextFieldDialog;
import views.MyJFramePpal;
import views.MyMessage;

public class JDialogRegister extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextFieldDialog name, cc;
	private JButtonsMenuAndDialogs buttonAccept, buttonCancel;

	public JDialogRegister(MyJFramePpal frame, ActionListener actionListener) {
		setMinimumSize(new Dimension(350, 400));
		setMaximumSize(new Dimension(350, 400));
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
		name = new JTextFieldDialog(MyMessage.IN_NAME);
		namePanel.add(name);
		add(namePanel);
		Panel ccPanel = new Panel();
		ccPanel.setBackground(colorPanel);
		cc = new JTextFieldDialog(MyMessage.IN_CC);
		ccPanel.add(cc);
		add(ccPanel);
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
		buttonAccept = new JButtonsMenuAndDialogs(MyMessage.ACCEPT, 120, 60);
		buttonAccept.addActionListener(actionListenner);
		buttonAccept.setActionCommand(Commands.ACCEPT.toString());
		buttonAccept.setFont(new Font(MyMessage.FONT_RUBIK, Font.BOLD, 14));
		buttonAccept.setBackground(Color.GREEN);
		buttonAccept.setForeground(Color.WHITE);
		panelButtons.add(buttonAccept);
		buttonCancel = new JButtonsMenuAndDialogs(MyMessage.CANCEL, 120, 60);
		buttonCancel.addActionListener(actionListenner);
		buttonCancel.setActionCommand(Commands.CANCEL.toString());
		buttonCancel.setFont(new Font(MyMessage.FONT_RUBIK, Font.BOLD, 14));
		buttonCancel.setBackground(Color.RED);
		buttonCancel.setForeground(Color.WHITE);
		panelButtons.add(buttonCancel);
		add(panelButtons);
	}

	public void clearComponents() {
		name.setText(MyMessage.EMPTY);
		cc.setText(MyMessage.EMPTY);
	}

}
