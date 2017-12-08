package com.neuSep17.ui;

import javax.swing.*;
import java.awt.*;
class DealerScreen extends JFrame
{


    public DealerScreen()
    {

        JFrame frame = new JFrame();
        setTitle("Dealer Operations");
        frame.setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);

        setLayout(new BorderLayout());


        JLabel background=new JLabel(new ImageIcon("C:\\Users\\nisha\\Desktop\\car-makers.jpg"));

        background.setLayout(new FlowLayout());

        frame.add(background);

        JLabel welcomeDealerLabel = new JLabel("Welcome Administrator!!");
        background.add(welcomeDealerLabel);

        JButton manageIncentivesButton = new JButton("Manage Incentives");
        background.add(manageIncentivesButton);

        JButton manageInventoryButton = new JButton("Manage Inventory");
        background.add(manageInventoryButton);

        JButton salesButton = new JButton("Sales");
        background.add(salesButton);

        JButton serviceButton = new JButton("Service");
        background.add(serviceButton);

        JButton employeeButton = new JButton("Employees");
        background.add(employeeButton);



    }


    public static void main(String args[])
    {
        new DealerScreen();
    }
}