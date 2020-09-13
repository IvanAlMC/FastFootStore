package views.body;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import views.MyMessage;

public class JPanelBody extends JPanel{

	private static final long serialVersionUID = 1L;
	public static final int WIDTH_SCREEN = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	public static final int HEIGHT_SCREEN = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	
	public JPanelBody() {
		setBackground(Color.WHITE);
		initImage();
	}
	
	public void initImage() {
		JLabel label = new JLabel();
		ImageIcon originalImage = new ImageIcon(MyMessage.BACK_PATH);
        ImageIcon scaleIcon = new ImageIcon(originalImage.getImage().getScaledInstance(WIDTH_SCREEN-100, HEIGHT_SCREEN-290, java.awt.Image.SCALE_DEFAULT));
        label.setFocusable(false);
		label.setIcon(scaleIcon);
		label.setOpaque(false);
		setOpaque(true);
		this.add(label);
	}
}
