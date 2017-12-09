//package com.neuSep17.ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class DealerScreen extends JFrame {
    public DealerScreen() {
        try {
            JFrame frame = new JFrame("Dealer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new Background());
            JPanel menuButtonsPanel = createMenuButtonsPanel();
            menuButtonsPanel.setOpaque(false);
            frame.add(menuButtonsPanel);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        } catch (Exception e) {

        }
    }

    public class Background extends JPanel {

        private BufferedImage backgroundImage;

        public Background() throws IOException {
            this.backgroundImage = ImageIO.read(new File("C:\\Users\\nisha\\Desktop\\car-makers.jpg"));
            setLayout(new BorderLayout());
        }

        @Override
        public Dimension getPreferredSize() {
            return backgroundImage == null ? new Dimension(200, 200) : new Dimension(backgroundImage.getWidth(), backgroundImage.getHeight());
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, this);
        }
    }




    private void manageIncentivesButtonActionPerformed(ActionEvent e) {
        // TODO
    }

    private void manageInventoryButtonActionPerformed(ActionEvent e) {
        // TODO
    }

    private JPanel createMenuButtonsPanel() {
        JPanel mainPanel;
        JLabel welcomeLabel;
        JButton manageIncentivesButton;
        JButton manageInventoryButton;

        mainPanel = new JPanel();
        welcomeLabel = new JLabel();
        manageIncentivesButton = new JButton();
        manageInventoryButton = new JButton();


        //======== mainPanel ========
        {
            mainPanel.setMinimumSize(null);
            mainPanel.setBackground(new Color(0, 102, 102));

            mainPanel.setLayout(new GridBagLayout());
            ((GridBagLayout) mainPanel.getLayout()).columnWidths = new int[]{315};
            ((GridBagLayout) mainPanel.getLayout()).rowHeights = new int[]{0, 82, 0, 0};

            //---- welcomeLabel ----
            welcomeLabel.setText("Welcome Administrator!");
            welcomeLabel.setFont(welcomeLabel.getFont().deriveFont(welcomeLabel.getFont().getSize() + 48f));
            welcomeLabel.setHorizontalAlignment(SwingConstants.LEFT);
            welcomeLabel.setBackground(Color.WHITE);
            welcomeLabel.setOpaque(true);

            mainPanel.add(welcomeLabel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                    new Insets(0, 0, 59, 0), 0, 0));


            //---- manageIncentivesButton ----
            manageIncentivesButton.setText("Manage Inventory");
            manageIncentivesButton.setFont(new Font("Calibri", Font.BOLD, 18));
            manageIncentivesButton.setForeground(Color.white);
            manageIncentivesButton.setBackground(new Color(52, 56, 51));
            mainPanel.add(manageIncentivesButton, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                    new Insets(0, 0, 59, 0), 0, 0));

            //---- manageInventoryButton ----
            manageInventoryButton.setText("Manage Inventory");
            manageInventoryButton.setFont(new Font("Calibri", Font.BOLD, 18));
            manageInventoryButton.setForeground(Color.white);
            manageInventoryButton.setBackground(new Color(52, 56, 51));
            manageInventoryButton.setOpaque(true);
            mainPanel.add(manageInventoryButton, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                    new Insets(0, 0, 59, 0), 0, 0));
        }
        return mainPanel;
    }

    public static void main(String args[]) {
        new DealerScreen();
    }
}