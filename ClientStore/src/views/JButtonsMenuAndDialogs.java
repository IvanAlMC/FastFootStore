package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;


public class JButtonsMenuAndDialogs extends JButton{

    private static final long serialVersionUID = 1L;
    public static final int DIMENSION_WHIDTH = 180;
    public static final int DIMENSION_HEIGHT = 100;
    private JButton button;
	
    public JButtonsMenuAndDialogs(String text, String routeImage) {
        setText(text);   
        setFont(new Font(MyMessage.FONT_RUBIK, Font.BOLD, 12));
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
        setPreferredSize(new Dimension(DIMENSION_WHIDTH,DIMENSION_HEIGHT));
    	setBorderPainted(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setIcon(convertToIcon(routeImage));
        setHorizontalTextPosition(SwingConstants.CENTER);
        setVerticalTextPosition(SwingConstants.BOTTOM);
        button = this;
        super.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseEntered(MouseEvent arg0){
            	button.setBackground(MyMessage.COLOR_1);
        		setBorderPainted(false);
            }
			@Override
            public void mouseExited(MouseEvent e){
            	button.setBackground(Color.BLACK);
        		setBorderPainted(false);
            }
        });
    } 
    
    public JButtonsMenuAndDialogs(String text, String routeImage, int large) {
        setText(text);   
        setFont(new Font(MyMessage.FONT_RUBIK, Font.BOLD, 12));
        setBackground(Color.WHITE);
        setForeground(Color.BLACK);
        setPreferredSize(new Dimension(large,large));
    	setBorderPainted(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setIcon(convertToIcon(routeImage));
        setHorizontalTextPosition(SwingConstants.CENTER);
        setVerticalTextPosition(SwingConstants.BOTTOM);
        button = this;
        super.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseEntered(MouseEvent arg0){
            	button.setBackground(MyMessage.COLOR_1);
        		setBorderPainted(false);
            }
			@Override
            public void mouseExited(MouseEvent e){
            	button.setBackground(Color.WHITE);
        		setBorderPainted(false);
            }
        });
    } 
	
    private static Icon convertToIcon(String route) {
    	ImageIcon icon = new ImageIcon(route);
    	Icon scaleIcon = new ImageIcon(icon.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT));
    	return scaleIcon;
    } 
	
}
