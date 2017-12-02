import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Delete {

   private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	/*	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete window = new Delete();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
		IntenciveDelete d=new IntenciveDelete();
	}

	/**
	 * Create the application.
	 */
	public Delete() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void displayCenter(JFrame frame)
	{
		int windowWidth = frame.getWidth();                     //get the width of the window
	    int windowHeight = frame.getHeight();                   //get the height
	    Toolkit kit = Toolkit.getDefaultToolkit();              //define tool
	    Dimension screenSize = kit.getScreenSize();             //get the size of the screen
	    int screenWidth = screenSize.width;                     //get the width of the screen
	    int screenHeight = screenSize.height;                   //get the height of the screen
	    frame.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);//display the frame in the center of the screen 
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Delete");
		frame.setBounds(100, 100, 350, 200);
		displayCenter(frame); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.white);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("      Do you really want to delete this record?");
		lblNewLabel.setBounds(20, 44, 330, 45);
		frame.getContentPane().add(lblNewLabel);
		
		final JButton btnNo = new JButton("No");
		btnNo.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnNo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnNo.setForeground(Color.GRAY);
            }
            public void mouseExited(MouseEvent e) {
            	btnNo.setCursor(Cursor.getDefaultCursor());
            	btnNo.setForeground(Color.BLACK);
            }
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.dispose();
			}
		});
		btnNo.setBounds(60, 101, 93, 29);
		frame.getContentPane().add(btnNo);
		
		final JButton btnYesiAmSure = new JButton("Yes");
		btnYesiAmSure.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnYesiAmSure.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnYesiAmSure.setForeground(Color.GRAY);
            }
            public void mouseExited(MouseEvent e) {
            	btnYesiAmSure.setCursor(Cursor.getDefaultCursor());
            	btnYesiAmSure.setForeground(Color.BLACK);
            }
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				JFrame frame2=new JFrame();
				frame2.setBounds(100,100,350,150);
				frame2.setBackground(Color.white);
				frame2.getContentPane().setLayout(null);
				displayCenter(frame2);
				JLabel lblNewLabel2 = new JLabel("  Congratulations!   Successfully delete!");
				lblNewLabel2.setBounds(30, 44, 330, 45);
				frame2.getContentPane().add(lblNewLabel2);
				frame2.setVisible(true);
			}
		});
		btnYesiAmSure.setBounds(197, 101, 93, 29);
		frame.getContentPane().add(btnYesiAmSure);
	}
}
