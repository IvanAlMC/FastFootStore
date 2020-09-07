package views;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import views.dialogs.JDialogAdd;
import views.dialogs.JDialogCreate;
import views.dialogs.JDialogDelete;
import views.dialogs.JDialogRegister;

public class MyJFramePpal extends JFrame{

	
	private static final long serialVersionUID = 1L;
	private JPanelPpal panel;
	private JPanelClient client;
	private JPanelAdmin admin;
	private JScrollPane jScrollPane, jScrollPane1, jScrollPane2;
	private JDialogCreate create;
	private JDialogDelete delete;
	private JDialogAdd add;
	private JDialogRegister register;

	
	public MyJFramePpal(ActionListener actionListener) {
		setMinimumSize(new Dimension(900,600));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setIconImage(new ImageIcon(MyMessage.BURGER_SHOT_PATH).getImage());
		setTitle(MyMessage.BURGER_SHOT);
		initComponents(actionListener);
		this.setVisible(true);
		jScrollPane2 = new JScrollPane();
		jScrollPane2.setViewportView(panel);
		this.add(jScrollPane2);
		jScrollPane2.setVisible(true);
	}
	
	public void initComponents(ActionListener actionListener) {
		panel = new JPanelPpal(actionListener);
		this.add(panel);
		client = new JPanelClient(actionListener);
		this.add(client);
		admin = new JPanelAdmin(actionListener);
		this.add(admin);
		panel.setVisible(true);
		admin.setVisible(false);
		client.setVisible(false);
		create = new JDialogCreate(this, actionListener);
		delete = new JDialogDelete(this, actionListener);
		add = new JDialogAdd(this, actionListener);
		register = new JDialogRegister(this, actionListener);
	}
	
	public void showAdminPanel() {
		panel.setVisible(false);
		admin.setVisible(true);
		client.setVisible(false);
		jScrollPane = new JScrollPane();
		jScrollPane.setViewportView(admin);
		jScrollPane2.setVisible(false);
		this.add(jScrollPane);
	}
	
	public void showClientPanel() {
		panel.setVisible(false);
		admin.setVisible(false);
		client.setVisible(true);
		jScrollPane1 = new JScrollPane();
		jScrollPane1.setViewportView(client);
		jScrollPane2.setVisible(false);
		this.add(jScrollPane1);
	}
	
	public void openDialogAdd() {
		add.setVisible(true);
	}
	
	public void closeDialogAdd() {
		add.setVisible(false);
		add.clearComponents();
	}
	
	public void openDialogDelete() {
		delete.setVisible(true);
	}
	
	public void closeDialogDelete() {
		delete.setVisible(false);
		delete.clearComponents();
	}
	
	public void openDialogCreate() {
		create.setVisible(true);
	}
	
	public void closeDialogCreate() {
    	create.setVisible(false);
		create.clearComponents();
    }
	
	public void openDialogRegister() {
		register.setVisible(true);
	}
	
	public void closeDialogRegister() {
    	register.setVisible(false);
		register.clearComponents();
    }
}
