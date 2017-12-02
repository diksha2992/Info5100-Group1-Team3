
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DealerScreen {

    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel distanceLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;

    public static void main(String[] args) throws IOException {
        DealerScreen welcome = new DealerScreen();
        welcome.createUI();
    }

    public void createUI() throws IOException {

        prepareGUI();

        JPanel vehiclesPanel = new JPanel(new GridLayout(5,1));
        JButton incentive = getIncentiveButton();
        JButton inventory = getInventoryButton();
        JButton sales = getSalesButton();
        vehiclesPanel.add(incentive);
        vehiclesPanel.add(new JLabel("                            "));
        vehiclesPanel.add(inventory);
        vehiclesPanel.add(new JLabel("                            "));
        vehiclesPanel.add(sales);

        JPanel managePanel = new JPanel(new GridLayout(5,1));
        JButton appointments = getAppointmentsButton();
        JButton employees = getEmployeesButton();
        JButton schedules = getSchedulesButton();
        managePanel.add(appointments);
        managePanel.add(new JLabel("                            "));
        managePanel.add(employees);
        managePanel.add(new JLabel("                            "));
        managePanel.add(schedules);

        JPanel dummyPanel = new JPanel();
        dummyPanel.add(new JLabel("                            "));

        JPanel outer = new JPanel();

        outer.add(vehiclesPanel);
        outer.add(dummyPanel);
        outer.add(managePanel);
        controlPanel.add(outer);
        mainFrame.setVisible(true);
    }

    private void prepareGUI() throws IOException {
        mainFrame = new JFrame("Welcome Dealer");
        mainFrame.setSize(2500,2000);
        mainFrame.setLayout(new GridLayout(2, 1));

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
        }

        JPanel imageNestedPanel = new JPanel();
        imageNestedPanel.setLayout(new GridLayout(2,1));
        JLabel imageLabel = pictures();

        headerLabel = new JLabel("Welcome Dealer", JLabel.CENTER);
        headerLabel.setFont(new Font("Arial", Font.PLAIN, 50));

        imageNestedPanel.add(imageLabel);
        imageNestedPanel.add(headerLabel);

        statusLabel = new JLabel("", JLabel.CENTER);
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 40));

        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(imageNestedPanel);
        mainFrame.add(controlPanel);
        mainFrame.setVisible(true);
    }


    private JButton getSalesButton() {

        JButton Sales = new JButton("Sales");
        Sales.setFont(new Font("Arial", Font.BOLD, 14));
        Sales.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText("Clicked on Sales");
            }
        });

        return Sales;
    }
    private JButton getEmployeesButton() {

        JButton Employees = new JButton("Manage Employees");
        Employees.setFont(new Font("Arial", Font.BOLD, 14));
        Employees.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText("Clicked on Manage Employee");
            }
        });

        return Employees;
    }

    private JButton getInventoryButton() {

        JButton Inventory = new JButton("Manage Inventory");
        Inventory.setFont(new Font("Arial", Font.BOLD, 14));
        Inventory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //statusLabel.setText("Dealer: "+chooseDealer.getSelectedItem()+" is selected.");
            }
        });
        return Inventory;
    }

    private JButton getIncentiveButton() {

        JButton incentiveButton = new JButton("Manage Incentives");
        incentiveButton.setFont(new Font("Arial", Font.BOLD, 14));
        incentiveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //statusLabel.setText("Dealer: "+chooseDealer.getSelectedItem()+" is selected.");
                try {
                    IncentiveScreen screen = new IncentiveScreen();
                }
                catch(Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
        return incentiveButton;

    }

    private JButton getAppointmentsButton() {

        JButton appointmentsButton = new JButton("Appointments");
        appointmentsButton.setFont(new Font("Arial", Font.BOLD, 14));
        appointmentsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //statusLabel.setText("Dealer: "+chooseDealer.getSelectedItem()+" is selected.");
            }
        });
        return appointmentsButton;

    }

    private JButton getSchedulesButton() {

        JButton schedulesButton = new JButton("Schedules");
        schedulesButton.setFont(new Font("Arial", Font.BOLD, 14));
        schedulesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //statusLabel.setText("Dealer: "+chooseDealer.getSelectedItem()+" is selected.");
            }
        });
        return schedulesButton;

    }

    private JLabel pictures() throws IOException{
        JLabel picLabel = new JLabel(new ImageIcon("dealerScreen2.jpg"));
        picLabel.setSize(new Dimension(500, 200));

        return picLabel;
    }
}



