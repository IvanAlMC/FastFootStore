package views;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class IconLabel extends JLabel{

 
	private static final long serialVersionUID = 1L;

	public IconLabel(int width, int height) {
        ImageIcon originalImage = new ImageIcon(MyMessage.LOGO);
        ImageIcon scaleIcon = new ImageIcon(originalImage.getImage().getScaledInstance(width, height, java.awt.Image.SCALE_DEFAULT));
        setFocusable(false);
		setIcon(scaleIcon);
		setOpaque(false);
		setForeground(Color.WHITE);
		setOpaque(true);
        
    }   

}
