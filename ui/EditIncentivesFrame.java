package Edit;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class EditIncentivesFrame {

	private JFrame frame;
	private JTextField txtDiscount1;
	private JTextField txtEnterTitle;
	private JTextField txtPrice;
	private JTextField txtId;
	private JTextField txtMileage;
	private JTextField txtYear;
	private JTextField txtMake;
	private JTextField txtModel;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditIncentivesFrame window = new EditIncentivesFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public EditIncentivesFrame() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(30, 20, 1200, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Edit Incentives: Dealer Discount");
		
		//********************leftPanel************************
		JPanel leftPanel = new JPanel();
		leftPanel.setBounds(10, 100, 520, 475);
		frame.getContentPane().add(leftPanel);
		leftPanel.setLayout(null);
		
		//start end date
		JLabel askDate = new JLabel("When does this Incentive start and end?");
		askDate.setBounds(10, 135, 305, 19);
		leftPanel.add(askDate);
		askDate.setFont(new Font("Arial", Font.BOLD, 16));
		
		JLabel lblStartDate = new JLabel("Start Date(yyyy-mm-dd)");
		lblStartDate.setBounds(10, 160, 150, 15);
		leftPanel.add(lblStartDate);
		lblStartDate.setFont(new Font("Arial", Font.PLAIN, 13));
		
		//get time model
		SpinnerDateModel modelStart = new SpinnerDateModel();
		SpinnerDateModel modelEnd = new SpinnerDateModel();
		
		//create spinner object
		JSpinner start = new JSpinner(modelStart);
		start.setBounds(10, 175, 105, 25);
		leftPanel.add(start);
		start.setValue(new Date());
		JSpinner.DateEditor sEditor = new JSpinner.DateEditor(start,"yyyy-MM-dd");
		start.setEditor(sEditor);
		
		JLabel lblEndDate = new JLabel("End Date(yyyy-mm-dd)");
		lblEndDate.setBounds(250, 160, 135, 15);
		leftPanel.add(lblEndDate);
		lblEndDate.setFont(new Font("Arial", Font.PLAIN, 13));
		JSpinner end = new JSpinner(modelEnd);
		end.setBounds(250, 175, 103, 25);
		leftPanel.add(end);
		end.setValue(new Date());
		JSpinner.DateEditor dEditor = new JSpinner.DateEditor(end,"yyyy-MM-dd");
		end.setEditor(dEditor);
		
		//discount
		JLabel lblDiscount = new JLabel("Discount:");
		lblDiscount.setBounds(10, 220, 85, 15);
		leftPanel.add(lblDiscount);
		lblDiscount.setFont(new Font("Arial", Font.BOLD, 16));
		
		JLabel label = new JLabel("$");
		label.setFont(new Font("Arial", Font.BOLD, 16));
		label.setBounds(100, 240, 10, 25);
		leftPanel.add(label);
		
		txtDiscount1 = new JTextField();
		txtDiscount1.setBounds(10, 240, 85, 25);
		leftPanel.add(txtDiscount1);
		txtDiscount1.setColumns(10);
		
		//title
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setFont(new Font("Arial", Font.BOLD, 16));
		lblTitle.setBounds(10, 70, 54, 15);
		leftPanel.add(lblTitle);
		
		txtEnterTitle = new JTextField();
		txtEnterTitle.setFont(new Font("Arial", Font.ITALIC, 12));
		txtEnterTitle.setBounds(10, 90, 400, 25);
		leftPanel.add(txtEnterTitle);
		txtEnterTitle.setColumns(10);
		
		//description
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setFont(new Font("Arial", Font.BOLD, 16));
		lblDescription.setBounds(10, 280, 105, 15);
		leftPanel.add(lblDescription);
		
		JTextArea txtDescriptions = new JTextArea();
		txtDescriptions.setFont(new Font("Arial", Font.ITALIC, 12));
		txtDescriptions.setBounds(20, 310, 420, 50);
		leftPanel.add(txtDescriptions);
		
		//disclaimer
		JLabel lblDisclaimer = new JLabel("Disclaimer:");
		lblDisclaimer.setFont(new Font("Arial", Font.BOLD, 16));
		lblDisclaimer.setBounds(10, 380, 105, 15);
		leftPanel.add(lblDisclaimer);
		
		JTextArea txtDisclaimer = new JTextArea();
		txtDisclaimer.setFont(new Font("Arial", Font.ITALIC, 12));
		txtDisclaimer.setBounds(20, 410, 420, 50);
		leftPanel.add(txtDisclaimer);
		
		//incentive id
		JLabel lblIncentiveId = new JLabel("Incentive ID");
		lblIncentiveId.setFont(new Font("Arial", Font.BOLD, 16));
		lblIncentiveId.setBounds(10, 10, 90, 15);
		leftPanel.add(lblIncentiveId);
		
		txtId = new JTextField();
		txtId.setBounds(10, 30, 150, 20);
		leftPanel.add(txtId);
		txtId.setColumns(10);
		//make it uneditable
		txtId.setEditable(false);
		
		
		
		//*************************rightPanel******************************
		JPanel rightPanel = new JPanel();
		rightPanel.setBounds(535, 100, 640, 475);
		frame.getContentPane().add(rightPanel);
		rightPanel.setLayout(null);
		
		//right title
		JLabel lblApplyToInventory = new JLabel("Apply To Inventory");
		lblApplyToInventory.setFont(new Font("Arial", Font.BOLD, 16));
		lblApplyToInventory.setBounds(36, 62, 150, 20);
		rightPanel.add(lblApplyToInventory);
		
		//category
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setFont(new Font("Arial", Font.BOLD, 14));
		lblCategory.setBounds(35, 110, 68, 20);
		rightPanel.add(lblCategory);
		
		JComboBox cbCategory = new JComboBox();
		cbCategory.setBounds(120, 110, 150, 20);
		rightPanel.add(cbCategory);
		cbCategory.setModel(new DefaultComboBoxModel<>(new String[] {
				"All",
				"New",
				"Used",
		}));
		
		
		//year
		JLabel lblYear = new JLabel("Year");
		lblYear.setFont(new Font("Arial", Font.BOLD, 14));
		lblYear.setBounds(35, 160, 68, 20);
		rightPanel.add(lblYear);
		
		txtYear = new JTextField();
		txtYear.setBounds(120, 161, 150, 20);
		rightPanel.add(txtYear);
		txtYear.setColumns(10);

		
		//make
		JLabel lblNewLabel = new JLabel("Make");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(35, 210, 68, 20);
		rightPanel.add(lblNewLabel);
		
		txtMake = new JTextField();
		txtMake.setBounds(120, 211, 150, 20);
		rightPanel.add(txtMake);
		txtMake.setColumns(10);
		
		
		//model
		JLabel lblModel = new JLabel("Model");
		lblModel.setFont(new Font("Arial", Font.BOLD, 14));
		lblModel.setBounds(35, 260, 68, 20);
		rightPanel.add(lblModel);

		txtModel = new JTextField();
		txtModel.setBounds(120, 261, 150, 20);
		rightPanel.add(txtModel);
		txtModel.setColumns(10);
		
		
		//trim
		JLabel lblTrim = new JLabel("Trim");
		lblTrim.setFont(new Font("Arial", Font.BOLD, 14));
		lblTrim.setBounds(340, 210, 68, 20);
		rightPanel.add(lblTrim);
		
		JComboBox cbTrim = new JComboBox();
		cbTrim.setBounds(420, 210, 150, 20);
		rightPanel.add(cbTrim);
		cbTrim.setModel(new DefaultComboBoxModel<>(new String[] {
				"All",
				"High",
				"Mid",
				"Base",
		}));
		
		
		//color
		JLabel lblColor = new JLabel("Color");
		lblColor.setFont(new Font("Arial", Font.BOLD, 14));
		lblColor.setBounds(340, 110, 68, 20);
		rightPanel.add(lblColor);
		
		JComboBox cbColor = new JComboBox();
		cbColor.setBounds(420, 110, 150, 20);
		rightPanel.add(cbColor);
		cbColor.setModel(new DefaultComboBoxModel<>(new String[] {
				"All",
				"Black",
				"White",
				"Green",
				"Blue",
				"Red",
				"Yellow",
		}));
		
		
		//type
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Arial", Font.BOLD, 14));
		lblType.setBounds(340, 160, 68, 20);
		rightPanel.add(lblType);
		
		JComboBox cbType = new JComboBox();
		cbType.setBounds(420, 160, 150, 20);
		rightPanel.add(cbType);
		cbType.setModel(new DefaultComboBoxModel<>(new String[] {
				"All",
				"SUV",
				"Truck",
				"Sedan",
				"Van",
				"Coupe",
				"Wagon",
				"Convertible",
				"Sport",
				"Diesel",
				"Crossover"
		}));
		
		
		//price
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Arial", Font.BOLD, 14));
		lblPrice.setBounds(35, 310, 68, 20);
		rightPanel.add(lblPrice);
		
		JComboBox cbPrice = new JComboBox();
		cbPrice.setBounds(120, 310, 90, 20);
		rightPanel.add(cbPrice);
		cbPrice.setModel(new DefaultComboBoxModel<>(new String[] {
				"Null",
				"<=",
				">=",
		}));
		
		txtPrice = new JTextField();
		txtPrice.setBounds(220, 310, 100, 20);
		rightPanel.add(txtPrice);
		txtPrice.setColumns(10);
		txtPrice.setEditable(false);
		
		
		//mileage
		JLabel lblMileage = new JLabel("Mileage");
		lblMileage.setFont(new Font("Arial", Font.BOLD, 14));
		lblMileage.setBounds(36, 360, 68, 20);
		rightPanel.add(lblMileage);
		
		JComboBox cbMileage = new JComboBox();
		cbMileage.setBounds(120, 360, 90, 20);
		rightPanel.add(cbMileage);
		cbMileage.setModel(new DefaultComboBoxModel<>(new String[] {
				"Null",
				"<=",
				">=",
		}));
		
		txtMileage = new JTextField();
		txtMileage.setBounds(220, 360, 100, 20);
		rightPanel.add(txtMileage);
		txtMileage.setColumns(10);
		txtMileage.setEditable(false);
		
		
		//apply button
		JButton applyBtn = new JButton("Apply");
		applyBtn.setBounds(280, 420, 93, 23);
		rightPanel.add(applyBtn);
		
		//top panel
		JPanel topPanel = new JPanel();
		topPanel.setBounds(180, 20, 700, 70);
		frame.getContentPane().add(topPanel);
		
		JLabel lblTopTitle = new JLabel("Edit Incentives");
		lblTopTitle.setFont(new Font("Arial", Font.BOLD, 30));
		topPanel.add(lblTopTitle);
		
	}

}

