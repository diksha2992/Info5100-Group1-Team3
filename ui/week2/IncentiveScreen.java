import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
public class IncentiveScreen extends JFrame
{
	    private static JFrame mainFrame;
	    private JPanel headerPanel;
	    private JPanel footerPanel;
	    private JPanel listPanel;
	    private JPanel sortPanel;
	    private JButton addButton;
	    private JLabel[] label;
	    private JButton[] editButtons;
	    private JButton[] deleteButtons;
	    private JPanel[] jp;
	    private ImageIcon[] ii;
	    private boolean asc=false;
	    private String sortoption="";
	    private String searchcontent="";
	    private JLabel[] imageLabel;
	    private JButton searchButton;
	    private int length;
	    private ArrayList<Incentive> incentives;//to save incentives read from file
	    private ArrayList<Incentive> Allincentives;
	    private FileReading fr;
	    private String dealerid;
	    private JComboBox jsort;
	    private JButton searchby;
	    private JLabel sort;
	    private JComboBox order;
	    private JTextField jtf;
	    private JButton viewAll;
	  //  private IncentiveImple;
	    public IncentiveScreen() throws FileNotFoundException 
	    {
	    	//this.dealerid=dealerid;
	        mainFrame = new JFrame();
	        initialize();
	        createComponents();
	        addComponents();
	        addListeners();
	        makeThisVisible();
	    }

	    private void initialize() throws FileNotFoundException {
	    //	IncentiveImple iImple=new IncentiveImple();
	    	FileReading fr=new FileReading(new File("incentives.txt"));
	    //	incentives=iImple.getIncentive(dealerid);
	    	incentives=fr.getAllIncentives();
	    	Allincentives=incentives;
	    	length=incentives.size();
	    	label=new JLabel[length];
	    	editButtons=new JButton[length];
	    	deleteButtons=new JButton[length];
	    	jp=new JPanel[length];
	    	ii=new ImageIcon[length];
	    	imageLabel=new JLabel[length];
	        mainFrame.setTitle("Incentive Management");
	        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        mainFrame.setBackground(Color.lightGray);
	        mainFrame.setLayout(new BorderLayout());
	    }

	    public void createComponents() {
	        headerPanel = new JPanel();
	        headerPanel.setLayout(new GridLayout(2,1,10,10));
	        
	        footerPanel = new JPanel();
	      
	        listPanel = new JPanel();
	        listPanel.setLayout(new GridLayout(length,1,10,10));
	    }

	    public void addComponents() {
	        // Header
	    	JLabel headerTitle = new JLabel("Incentive Lists and Management");
	        JPanel title=new JPanel();
	        title.add(headerTitle);
	        sortPanel=new JPanel();
	        sort=new JLabel("Sort by");
	        jsort=createComboBox(new String[]{"ID","Title","StartDate","EndDate","Discount"});
	        jtf=new JTextField(5);
	        searchButton=new JButton("search");
	        viewAll=new JButton("viewAll");
	        order=createComboBox(new String[]{"asc","desc"});
	        JLabel searchby=new JLabel("Search by ID");
	        sortPanel.add(sort);
	        sortPanel.add(jsort);
	        sortPanel.add(order);
	        sortPanel.add(searchby);
	        sortPanel.add(jtf);
	        sortPanel.add(searchButton);
	        sortPanel.add(viewAll);
	        headerPanel.add(title);
	        headerPanel.add(sortPanel);
	        mainFrame.add(headerPanel,BorderLayout.NORTH);
	        

	        // Add button
	        addButton = new JButton("Add New Incentive");
	        addButton.setSize(200, 40);
	        footerPanel.add(addButton);
	        mainFrame.add(footerPanel, BorderLayout.SOUTH);
            
	        //add listpanel,according to sort and search
	        displayIncentives(incentives);
	        
	        mainFrame.add(listPanel, BorderLayout.CENTER);
	    }
	    
	    private void displayIncentives(ArrayList<Incentive> incentives)
	    {
	    	length=incentives.size();
	    	 for(int i=0;i<length;i++)
		        {
		        	    jp[i]=new JPanel();
		        		ii[i]=new ImageIcon("hot.png");
		                imageLabel[i]=new JLabel(ii[i]);
		                imageLabel[i].setBounds(0, 0,24,31);
		                jp[i].add(imageLabel[i],new Integer(Integer.MIN_VALUE));
		                String content="ID"+" "+incentives.get(i).getID()+", "+incentives.get(i).getDescription();
		               // label[i]=new JLabel("Incentive ID"+" "+incentives.get(i).getID()+", "+incentives.get(i).getDescription());
		                if(content.length()>30)
		                	content=content.substring(0,23)+"...";
		                label[i]=new JLabel(content);
			        	label[i].setForeground(Color.blue);
			        	editButtons[i]=new JButton("Edit");
			        	deleteButtons[i]=new JButton("Delete");
			        	jp[i].add(label[i]);
			        	jp[i].add(editButtons[i]);
			        	jp[i].add(deleteButtons[i]);
			        	listPanel.add(jp[i]);
		        }
	    }
	    
	    private JComboBox createComboBox(String[] items){
	        JComboBox jComboBox = new JComboBox(items);
	        return jComboBox;
	    }


	    public void addListeners() {
	    	//    final IncentiveService is=new IncentiveService();
	    	   /* jsort.addItemListener(new ItemListener()
	    	    {

					@Override
					public void itemStateChanged(ItemEvent e) {
						if(e.getStateChange()==ItemEvent.SELECTED)
						{
						//	IncentiveService is=new IncentiveService();
							sortoption=(String)jsort.getSelectedItem();
						//	incentives=is.getSortedIncentives(incentives, sortoption, asc);
							displayIncentives(incentives);
						}
					}	
	    	    });
	    	    order.addItemListener(new ItemListener()
	    	    {

					@Override
					public void itemStateChanged(ItemEvent e) {
						if(e.getStateChange()==ItemEvent.SELECTED)
						{
							if(order.getSelectedItem().toString().equals("asc"))
								asc=true;
							else
								asc=false;
						//	incentives=is.getSortedIncentives(incentives, sortoption, asc);
							displayIncentives(incentives);
						}
					}	
	    	    });*/
	    	    
	    	    searchButton.addMouseListener(new MouseAdapter() {
		 			public void mouseEntered(MouseEvent e) 
		 			{
		 				searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		 				searchButton.setForeground(Color.GRAY);
		             }
		             public void mouseExited(MouseEvent e) {
		            	searchButton.setCursor(Cursor.getDefaultCursor());
		            	searchButton.setForeground(Color.BLACK);
		             }
		 			//@Override
		 			/*public void mouseClicked(MouseEvent arg0) {
		 				try
		 				{
		 				searchcontent=jtf.getText();//check if it's empty.
		 				incentives=is.
		 				
		 				}
		 				catch (Exception ex) {
		 		            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error: cannot be empty!", JOptionPane.ERROR_MESSAGE);
		 		            ex.printStackTrace();
		 		        }
		 			}*/
		 		    });
	    	    
	    	    for(int i=0;i<length;i++)
	    	    {
	    	    	final JButton editButton=editButtons[i];
	    	    editButton.addMouseListener(new MouseAdapter() {
	 			public void mouseEntered(MouseEvent e) 
	 			{
	 				editButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	 				editButton.setForeground(Color.GRAY);
	             }
	             public void mouseExited(MouseEvent e) {
	            	editButton.setCursor(Cursor.getDefaultCursor());
	            	editButton.setForeground(Color.BLACK);
	             }
	 			@Override
	 			public void mouseClicked(MouseEvent arg0) {
	 				EditIncentivesFrame e=new EditIncentivesFrame();
	 				
	 			}
	 		    });
	    	    final JButton deleteButton=deleteButtons[i];
	    	    deleteButton.addMouseListener(new MouseAdapter() {
	 			public void mouseEntered(MouseEvent e) 
	 			{
	 				deleteButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	 				deleteButton.setForeground(Color.GRAY);
	             }
	             public void mouseExited(MouseEvent e) {
	            	deleteButton.setCursor(Cursor.getDefaultCursor());
	            	deleteButton.setForeground(Color.BLACK);
	             }
	 			@Override
	 			public void mouseClicked(MouseEvent arg0) 
	 			{
	 				IntenciveDelete d=new IntenciveDelete(); 
	 				//return incentive i;
	 				mainFrame.dispose();
	 				try {
						IncentiveScreen screen = new IncentiveScreen();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
	            
	            viewAll.addMouseListener(new MouseAdapter() {
		 			public void mouseEntered(MouseEvent e) 
		 			{
		 				viewAll.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		 				viewAll.setForeground(Color.GRAY);
		             }
		             public void mouseExited(MouseEvent e) {
		            	 viewAll.setCursor(Cursor.getDefaultCursor());
		            	 viewAll.setForeground(Color.BLACK);
		             }
		 			@Override
		 			public void mouseClicked(MouseEvent arg0) {
		 				displayIncentives(Allincentives);
		 			}
		 		});
	    	    }
	    	    
	    }
	    
	    private void makeThisVisible()
	    {
	        mainFrame.setSize(800, 1000);//make it smaller and in the middle of the screen
	        UI ui=new UI();
	        ui.displayCenter(mainFrame);
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