package com.neuSep17.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


public class AddIncFrame extends JFrame {
    public AddIncFrame() {
        initComponents();
        setVisible(true);
    }




    private void initComponents() {
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        addIncentiveLabel = new JLabel();
        titleLabel = new JLabel();
        applyToInventoryLabel = new JLabel();
        titleTextField = new JTextField();
        categoryLabel = new JLabel();
        categoryComboBox = new JComboBox<>();
        label1 = new JLabel();
        yearLabel = new JLabel();
        yearTextField = new JTextField();
        startDateLabel = new JLabel();
        makeLabel = new JLabel();
        makeTextField = new JTextField();
        textField1 = new JTextField();
        modelLabel = new JLabel();
        modelTextField = new JTextField();
        endDateLabel = new JLabel();
        priceLabel = new JLabel();
        priceTextField = new JTextField();
        endDateTextField = new JTextField();
        mileageLabel = new JLabel();
        mileageTextField = new JTextField();
        colorLabel = new JLabel();
        colorComboBox = new JComboBox<>();
        discountLabel = new JLabel();
        typeLabel = new JLabel();
        typeComboBox = new JComboBox<>();
        discountTextField = new JTextField();
        trimLabel = new JLabel();
        comboBox1 = new JComboBox<>();
        descriptionLabel = new JLabel();
        scrollPane1 = new JScrollPane();
        descriptionTextArea = new JTextArea();
        label2 = new JLabel();
        scrollPane2 = new JScrollPane();
        disclaimerTextArea = new JTextArea();
        buttonBar = new JPanel();
        applyButton = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setFont(new Font("Arial", Font.PLAIN, 14));
                contentPanel.setLayout(new GridBagLayout());
                ((GridBagLayout)contentPanel.getLayout()).columnWidths = new int[] {294, 0, 124, 0};

                //---- addIncentiveLabel ----
                addIncentiveLabel.setText("Add Incentives");
                addIncentiveLabel.setFont(new Font("Arial", Font.BOLD, 16));
                contentPanel.add(addIncentiveLabel, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- titleLabel ----
                titleLabel.setText("Title");
                titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
                contentPanel.add(titleLabel, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- applyToInventoryLabel ----
                applyToInventoryLabel.setText("Apply to Inventory");
                applyToInventoryLabel.setFont(new Font("Arial", Font.BOLD, 16));
                contentPanel.add(applyToInventoryLabel, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
                contentPanel.add(titleTextField, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- categoryLabel ----
                categoryLabel.setText("Category");
                categoryLabel.setFont(new Font("Arial", Font.BOLD, 16));
                contentPanel.add(categoryLabel, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- categoryComboBox ----
                categoryComboBox.setModel(new DefaultComboBoxModel<>(new String[] {
                    "All",
                    "New",
                    "Certified Pre-Owned",
                    "Used"
                }));
                contentPanel.add(categoryComboBox, new GridBagConstraints(3, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- label1 ----
                label1.setText("When does this incentive start and end?");
                label1.setFont(new Font("Arial", Font.BOLD, 16));
                contentPanel.add(label1, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- yearLabel ----
                yearLabel.setText("Year");
                yearLabel.setFont(new Font("Arial", Font.BOLD, 16));
                contentPanel.add(yearLabel, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- yearTextField ----
                yearTextField.setText("\t\t");
                contentPanel.add(yearTextField, new GridBagConstraints(3, 4, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- startDateLabel ----
                startDateLabel.setText("Start Date");
                startDateLabel.setFont(new Font("Arial", Font.PLAIN, 14));
                contentPanel.add(startDateLabel, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- makeLabel ----
                makeLabel.setText("Make");
                makeLabel.setFont(new Font("Arial", Font.BOLD, 16));
                contentPanel.add(makeLabel, new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
                contentPanel.add(makeTextField, new GridBagConstraints(3, 5, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- textField1 ----
                textField1.setToolTipText("Date should be in the format of 'YYYY-MM-DD'");
                textField1.setText("           ");
                contentPanel.add(textField1, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- modelLabel ----
                modelLabel.setText("Model");
                modelLabel.setFont(new Font("Arial", Font.BOLD, 16));
                contentPanel.add(modelLabel, new GridBagConstraints(2, 6, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
                contentPanel.add(modelTextField, new GridBagConstraints(3, 6, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- endDateLabel ----
                endDateLabel.setText("End Date");
                endDateLabel.setFont(new Font("Arial", Font.PLAIN, 14));
                contentPanel.add(endDateLabel, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- priceLabel ----
                priceLabel.setText("Price");
                priceLabel.setFont(new Font("Arial", Font.BOLD, 16));
                contentPanel.add(priceLabel, new GridBagConstraints(2, 7, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
                contentPanel.add(priceTextField, new GridBagConstraints(3, 7, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- endDateTextField ----
                endDateTextField.setToolTipText("Date should be in the format of 'YYYY-MM-DD'");
                contentPanel.add(endDateTextField, new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- mileageLabel ----
                mileageLabel.setText("Mileage");
                mileageLabel.setFont(new Font("Arial", Font.BOLD, 16));
                contentPanel.add(mileageLabel, new GridBagConstraints(2, 8, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
                contentPanel.add(mileageTextField, new GridBagConstraints(3, 8, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- colorLabel ----
                colorLabel.setText("Color");
                colorLabel.setFont(new Font("Arial", Font.BOLD, 16));
                contentPanel.add(colorLabel, new GridBagConstraints(2, 9, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- colorComboBox ----
                colorComboBox.setFont(new Font("Arial", Font.PLAIN, 12));
                colorComboBox.setModel(new DefaultComboBoxModel<>(new String[] {
                    "All",
                    "Black",
                    "White",
                    "Silver",
                    "Red",
                    "Blue",
                    "Grey",
                    "Other"
                }));
                contentPanel.add(colorComboBox, new GridBagConstraints(3, 9, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- discountLabel ----
                discountLabel.setText("Discount");
                discountLabel.setFont(new Font("Arial", Font.BOLD, 16));
                contentPanel.add(discountLabel, new GridBagConstraints(0, 10, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- typeLabel ----
                typeLabel.setText("Type");
                typeLabel.setFont(new Font("Arial", Font.BOLD, 16));
                contentPanel.add(typeLabel, new GridBagConstraints(2, 10, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- typeComboBox ----
                typeComboBox.setFont(new Font("Arial", Font.PLAIN, 12));
                typeComboBox.setModel(new DefaultComboBoxModel<>(new String[] {
                    "All",
                    "Sedan",
                    "Coupe",
                    "Convertible",
                    "Hatchback",
                    "SUV",
                    "Van",
                    "Pickup Truck"
                }));
                contentPanel.add(typeComboBox, new GridBagConstraints(3, 10, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- discountTextField ----
                discountTextField.setToolTipText("Maximum discount can be 9999$");
                contentPanel.add(discountTextField, new GridBagConstraints(0, 11, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- trimLabel ----
                trimLabel.setText("Trim");
                trimLabel.setFont(new Font("Arial", Font.BOLD, 16));
                contentPanel.add(trimLabel, new GridBagConstraints(2, 11, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- comboBox1 ----
                comboBox1.setFont(new Font("Arial", Font.PLAIN, 12));
                comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
                    "All",
                    "High",
                    "Middle",
                    "Low"
                }));
                contentPanel.add(comboBox1, new GridBagConstraints(3, 11, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- descriptionLabel ----
                descriptionLabel.setText("Description");
                descriptionLabel.setFont(new Font("Arial", Font.BOLD, 16));
                contentPanel.add(descriptionLabel, new GridBagConstraints(0, 12, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(descriptionTextArea);
                }
                contentPanel.add(scrollPane1, new GridBagConstraints(0, 13, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- label2 ----
                label2.setText("Disclaimer");
                label2.setFont(new Font("Arial", Font.BOLD, 16));
                contentPanel.add(label2, new GridBagConstraints(0, 14, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //======== scrollPane2 ========
                {
                    scrollPane2.setViewportView(disclaimerTextArea);
                }
                contentPanel.add(scrollPane2, new GridBagConstraints(0, 15, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0};

                //---- applyButton ----
                applyButton.setText("Apply");
                applyButton.setFont(new Font("Calibri", Font.PLAIN, 16));
                buttonBar.add(applyButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());

    }


    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel addIncentiveLabel;
    private JLabel titleLabel;
    private JLabel applyToInventoryLabel;
    private JTextField titleTextField;
    private JLabel categoryLabel;
    private JComboBox<String> categoryComboBox;
    private JLabel label1;
    private JLabel yearLabel;
    private JTextField yearTextField;
    private JLabel startDateLabel;
    private JLabel makeLabel;
    private JTextField makeTextField;
    private JTextField textField1;
    private JLabel modelLabel;
    private JTextField modelTextField;
    private JLabel endDateLabel;
    private JLabel priceLabel;
    private JTextField priceTextField;
    private JTextField endDateTextField;
    private JLabel mileageLabel;
    private JTextField mileageTextField;
    private JLabel colorLabel;
    private JComboBox<String> colorComboBox;
    private JLabel discountLabel;
    private JLabel typeLabel;
    private JComboBox<String> typeComboBox;
    private JTextField discountTextField;
    private JLabel trimLabel;
    private JComboBox<String> comboBox1;
    private JLabel descriptionLabel;
    private JScrollPane scrollPane1;
    private JTextArea descriptionTextArea;
    private JLabel label2;
    private JScrollPane scrollPane2;
    private JTextArea disclaimerTextArea;
    private JPanel buttonBar;
    private JButton applyButton;

}
