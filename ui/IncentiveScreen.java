package IncentiveBrowser;

import javax.swing.*;
import java.awt.*;

public class IncentiveScreen extends JFrame{

    private static JFrame mainFrame;
    private JPanel headerPanel;
    private JPanel footerPanel;
    private JPanel filterPanel;
    private JPanel listPanel;

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
        filterPanel = new JPanel();
        listPanel = new JPanel();
        listPanel.setLayout(new GridLayout(2, 1, 10, 10));
    }

    public void addComponents() {
        // Header
        JLabel headerTitle = new JLabel("Incentive Management");
        JButton inventoryButton = new JButton("Inventory");
        JButton incentiveButton = new JButton("Incentive");
        headerPanel.add(headerTitle);
        headerPanel.add(inventoryButton);
        headerPanel.add(incentiveButton);
        mainFrame.add(headerPanel, BorderLayout.NORTH);

        // Footer
        JLabel footerTitle = new JLabel("This is footer");
        footerPanel.add(footerTitle);
        mainFrame.add(footerPanel, BorderLayout.SOUTH);

        // Filter
        JLabel filterTitle = new JLabel("Filter");
        filterPanel.add(filterTitle);
        mainFrame.add(filterPanel, BorderLayout.WEST);

        // List
        JLabel listTitle = new JLabel("List");
        JButton addButton = new JButton("Add");
        addButton.setPreferredSize(new Dimension(100,50));
        JPanel records = new JPanel();
        records.setBackground(Color.gray);
        records.setLayout(new GridLayout(5, 3, 5, 5));

        JLabel desp1 = new JLabel("Description1");
        JButton editButton1 = new JButton("Edit");
        JButton deleteButton1 = new JButton("Delete");
        records.add(desp1);
        records.add(editButton1);
        records.add(deleteButton1);

        JLabel desp2 = new JLabel("Description2");
        JButton editButton2 = new JButton("Edit");
        JButton deleteButton2 = new JButton("Delete");
        records.add(desp2);
        records.add(editButton2);
        records.add(deleteButton2);

        JLabel desp3 = new JLabel("Description3");
        JButton editButton3 = new JButton("Edit");
        JButton deleteButton3 = new JButton("Delete");
        records.add(desp3);
        records.add(editButton3);
        records.add(deleteButton3);

        JLabel desp4 = new JLabel("Description4");
        JButton editButton4 = new JButton("Edit");
        JButton deleteButton4 = new JButton("Delete");
        records.add(desp4);
        records.add(editButton4);
        records.add(deleteButton4);

        JLabel desp5 = new JLabel("Description5");
        JButton editButton5 = new JButton("Edit");
        JButton deleteButton5 = new JButton("Delete");
        records.add(desp5);
        records.add(editButton5);
        records.add(deleteButton5);

        listPanel.add(addButton);
        listPanel.add(records);
        mainFrame.add(listPanel, BorderLayout.CENTER);

    }

    public void addListeners() {

    }

    private void makeThisVisible()
    {
        mainFrame.setSize(1280, 700);
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
