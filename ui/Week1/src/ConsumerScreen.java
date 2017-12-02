import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Hashtable;

public class ConsumerScreen {

    private static JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel footerLabel;
    private JLabel distanceLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;
    private JLabel imageLabel;
    private JComboBox<String> chooseDealer;


    public static void main(String[] args) throws IOException {
        ConsumerScreen  welcome = new ConsumerScreen();
        welcome.prepareGUI();

        
        JPanel imageNestedPanel = new JPanel();
        JPanel dealersListNestedPanel = new JPanel();
        JLabel label = new JLabel("Select Dealer:",JLabel.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 24));

        JPanel distanceNestedPanel = new JPanel();
        JLabel distanceTextLabel = new JLabel("Show dealers within distance (mi):", JLabel.CENTER);
        distanceTextLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        JSlider slider = welcome.getSlider();
      //  distanceNestedPanel.add(imageLabel);
        distanceNestedPanel.add(distanceTextLabel);
        distanceNestedPanel.add(slider);
        distanceNestedPanel.add(welcome.distanceLabel);

        JComboBox<String> dealersComboBox = welcome.getDealersComboBox();
        dealersListNestedPanel.add(label);
        dealersListNestedPanel.add(dealersComboBox);

        JPanel submitNestedPanel = new JPanel();
        JButton submitButton = welcome.getSubmitButton();
        submitNestedPanel.add(submitButton);

        JPanel outer = new JPanel(new GridLayout(5,1));
        outer.add(distanceNestedPanel);
        outer.add(dealersListNestedPanel);
        outer.add(submitNestedPanel);


        welcome.controlPanel.add(outer);
        welcome.mainFrame.setVisible(true);
    }
    
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

    private void prepareGUI() {
        mainFrame = new JFrame("Welcome User");
        mainFrame.setSize(1200,1000);//make it smaller than the whole screen
        mainFrame.setBackground(Color.white);
        displayCenter(mainFrame);//display in the center of the screen
        mainFrame.setLayout(new GridLayout(3, 2));

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception e) {
            System.out.println("Error setting native LAF: " + e);
        }
        
        ImageIcon background=new ImageIcon("beautiful.jpg");
        imageLabel=new JLabel(background);
        imageLabel.setBounds(0, 0, 1200, 1000);
        mainFrame.getLayeredPane().add(imageLabel,new Integer(Integer.MIN_VALUE));
        JPanel jp=(JPanel)mainFrame.getContentPane();
        jp.setOpaque(false);

        headerLabel = new JLabel("Welcome to your dream car site!", JLabel.CENTER);
        headerLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 50));
        statusLabel = new JLabel("", JLabel.CENTER);
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 24));

        distanceLabel = new JLabel("", JLabel.CENTER);
        distanceLabel.setFont(new Font("Arial", Font.PLAIN, 24));

        footerLabel = new JLabel("", JLabel.CENTER);

        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout() );

        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }

    private JButton getSubmitButton() {

        final JButton submitButton = new JButton("Submit");
        //add some effect
        submitButton.addMouseListener(new MouseAdapter() {
        	public void mouseEntered(MouseEvent e) 
 			{
        		submitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        		submitButton.setForeground(Color.GRAY);
             }
             public void mouseExited(MouseEvent e) {
            	submitButton.setCursor(Cursor.getDefaultCursor());
            	submitButton.setForeground(Color.BLACK);
             }
             public void mouseClicked(MouseEvent arg0) {
            	 statusLabel.setText("Dealer: "+" is selected.");
  			}
            public void actionPerformed(ActionEvent e) throws IOException {
                //statusLabel.setText("Dealer: "+chooseDealer.getSelectedItem()+" is selected.");
                //statusLabel.setText("Dealer: "+" is selected.");
//                DealerScreen welcome = new DealerScreen();
//                welcome.createUI();
//                System.out.println(chooseDealer.getSelectedItem());
                //output user's choice
            }
        });

        submitButton.setFont(new Font("Arial", Font.PLAIN, 20));
        submitButton.setPreferredSize(new Dimension(225, 50));
        return submitButton;
    }

    private JComboBox<String> getDealersComboBox(){
        String [] dealers = new String[]{"SeattleAudi","HondaBellevue"};
        chooseDealer   = new JComboBox<>(dealers);
        chooseDealer.setPreferredSize(new Dimension(600, 50));
        chooseDealer.setForeground(Color.BLACK);
        chooseDealer.setFont(new Font("Arial", Font.PLAIN, 24));

        return chooseDealer;
    }

    private JSlider getSlider() {
        // Set the slider
        JSlider slider = new JSlider();
        slider.setMinorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setFont(new Font("Arial", Font.PLAIN, 20));

        // Set the labels to be painted on the slider
        slider.setPaintLabels(true);

        // Add positions label in the slider
        Hashtable<Integer, JLabel> position = new Hashtable<Integer, JLabel>();
        position.put(0, new JLabel("0"));
        position.put(50, new JLabel("50"));
        position.put(100, new JLabel("100"));

        // Set the label to be drawn
        slider.setLabelTable(position);

        distanceLabel.setText("(selected: " + slider.getValue() +")");

        // Add change listener to the slider
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                distanceLabel.setText("(selected: " + ((JSlider)e.getSource()).getValue() +")");
            }
        });

        return slider;


    }
}

