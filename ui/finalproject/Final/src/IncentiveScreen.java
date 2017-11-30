import java.awt.EventQueue;

	import javax.swing.*;

	import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
public class IncentiveScreen extends JFrame{

	    private static JFrame mainFrame;
	    private JPanel headerPanel;
	    private JPanel footerPanel;
	    private JPanel listPanel;
	    private JButton deleteButton1;
	    private JButton addButton;
	    private JLabel[] label=new JLabel[20];
	    private JButton[] editButtons=new JButton[20];
	    private JButton[] deleteButtons=new JButton[20];
	    private JPanel[] jp=new JPanel[20];
	    private ImageIcon[] ii=new ImageIcon[20];
	    private JLabel[] imageLabel=new JLabel[20];
	    private ArrayList<Incentive> incentives;//to save incentives read from file
	    //add your buttons here.
	    public IncentiveScreen() {
	        mainFrame = new JFrame();
	        initialize();
	        createComponents();
	        addComponents();
	        addListeners();
	        makeThisVisible();
	    }

	    private void initialize() {
	        mainFrame.setTitle("Incentive Management");
	        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        mainFrame.setBackground(Color.lightGray);
	        mainFrame.setLayout(new BorderLayout());
	    }

	    public void createComponents() {
	        headerPanel = new JPanel();
	        footerPanel = new JPanel();
	       // filterPanel = new JPanel();
	        listPanel = new JPanel();
	        listPanel.setLayout(new GridLayout(20,1,10,10));
	        //listPanel.setLayout(new FlowLayout());
	    }

	    public void addComponents() {
	        // Header
	        JLabel headerTitle = new JLabel("Incentive Lists and Management");
	      //  JButton inventoryButton = new JButton("Inventory");
	     //   JButton incentiveButton = new JButton("Incentive");
	        headerPanel.add(headerTitle);
	    //    headerPanel.add(inventoryButton);
	  //      headerPanel.add(incentiveButton);
	        mainFrame.add(headerPanel, BorderLayout.NORTH);

	        // Footer
	        addButton = new JButton("Add New Incentive");
	        addButton.setSize(200, 40);
	     //   JLabel footerTitle = new JLabel("This is footer");
	        footerPanel.add(addButton);
	      //  footerPanel.add(footerTitle);
	        mainFrame.add(footerPanel, BorderLayout.SOUTH);

	        for(int i=0;i<20;i++)
	        {
	        	jp[i]=new JPanel();
	        		ii[i]=new ImageIcon("hot.png");
	                imageLabel[i]=new JLabel(ii[i]);
	                imageLabel[i].setBounds(0, 0,24,31);
	                jp[i].add(imageLabel[i],new Integer(Integer.MIN_VALUE));
	                label[i]=new JLabel("Incentive Description"+" "+i+" "+" Hot right now! Hurry up! ");
		        	label[i].setForeground(Color.blue);
		        	editButtons[i]=new JButton("Edit");
		        	deleteButtons[i]=new JButton("Delete");
		        	jp[i].add(label[i]);
		        	jp[i].add(editButtons[i]);
		        	jp[i].add(deleteButtons[i]);
		        	listPanel.add(jp[i]);

	        }
	        mainFrame.add(listPanel, BorderLayout.CENTER);
	    }

	    public void addListeners() {
	    	final int i=0;
	    	    editButtons[i].addMouseListener(new MouseAdapter() {
	 			public void mouseEntered(MouseEvent e) 
	 			{
	 				editButtons[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	 				editButtons[i].setForeground(Color.GRAY);
	             }
	             public void mouseExited(MouseEvent e) {
	            	editButtons[i].setCursor(Cursor.getDefaultCursor());
	            	editButtons[i].setForeground(Color.BLACK);
	             }
	 			@Override
	 			public void mouseClicked(MouseEvent arg0) {
	 				EditIncentivesFrame e=new EditIncentivesFrame();
	 				
	 			}
	 		});
	    	
	    	deleteButtons[i].addMouseListener(new MouseAdapter() {
	 			public void mouseEntered(MouseEvent e) 
	 			{
	 				deleteButtons[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	 				deleteButtons[i].setForeground(Color.GRAY);
	             }
	             public void mouseExited(MouseEvent e) {
	            	deleteButtons[i].setCursor(Cursor.getDefaultCursor());
	            	deleteButtons[i].setForeground(Color.BLACK);
	             }
	 			@Override
	 			public void mouseClicked(MouseEvent arg0) 
	 			{
	 				IntenciveDelete d=new IntenciveDelete(); 
	 				//return incentive i;
	 			}
	 		});
	    	
	            addButton.addMouseListener(new MouseAdapter() {
	 			public void mouseEntered(MouseEvent e) 
	 			{
	 				addButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	 				addButton.setForeground(Color.GRAY);
	             }
	             public void mouseExited(MouseEvent e) {
	            	 addButton.setCursor(Cursor.getDefaultCursor());
	            	 addButton.setForeground(Color.BLACK);
	             }
	 			@Override
	 			public void mouseClicked(MouseEvent arg0) {
	 				AddIncentiveScreen a=new AddIncentiveScreen();
	 				try {
						Incentive i=a.GetIncentive();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	 			}
	 		});
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
	    
	    private void makeThisVisible()
	    {
	        mainFrame.setSize(800, 1000);//make it smaller and in the middle of the screen
	        displayCenter(mainFrame);
	        mainFrame.setBackground(Color.white);
	        mainFrame.setVisible(true);
	    }

	    public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                    IncentiveScreen screen = new IncentiveScreen();
	                }
	                catch(Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	    }
	}

