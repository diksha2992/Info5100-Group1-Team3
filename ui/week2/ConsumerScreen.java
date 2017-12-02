package com.neuSep17.ui;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Hashtable;

public class ConsumerScreen extends UI {

    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel distanceLabel;
    private JPanel controlPanel;
    private JComboBox<String> chooseDealer;

    public ConsumerScreen() {
        super();
    }

    public static void main(String[] args) throws IOException {
        ConsumerScreen  consumerScreen = new ConsumerScreen();
        consumerScreen.createUI();
    }

    public void createUI() throws IOException {

        prepareGUI();

        JPanel distanceNestedPanel = new JPanel();
        JLabel distanceTextLabel = createLabel("Show dealers within distance (mi):", JLabel.CENTER);
        JSlider slider = getSlider();
        distanceNestedPanel.add(distanceTextLabel);
        distanceNestedPanel.add(slider);
        distanceNestedPanel.add(distanceLabel);

        JPanel dealersListNestedPanel = new JPanel();
        JLabel label = createLabel("Select Dealer:", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 40));
        chooseDealer = getDealersComboBox();
        dealersListNestedPanel.add(label);
        dealersListNestedPanel.add(chooseDealer);

        JPanel submitNestedPanel = new JPanel();
        JButton submitButton = getSubmitButton();
        submitNestedPanel.add(submitButton);

        JPanel outer = new JPanel(new GridLayout(5,1));
        outer.add(distanceNestedPanel);
        outer.add(dealersListNestedPanel);
        outer.add(submitNestedPanel);

        controlPanel.add(outer);
        mainFrame.setVisible(true);
    }

    private void prepareGUI() throws IOException {
        mainFrame = createFrame("Welcome User");
        mainFrame.setLayout(new GridLayout(3, 2));

        JPanel imageNestedPanel = new JPanel();
        imageNestedPanel.setLayout(new GridLayout(2,1));

        JLabel imageLabel = pictures();

        headerLabel = createLabel("Welcome to your dream car site!", JLabel.CENTER);
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        headerLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 100));

        imageNestedPanel.add(imageLabel);
        imageNestedPanel.add(headerLabel);

        distanceLabel = createLabel("", JLabel.CENTER);

        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(imageNestedPanel);
        mainFrame.add(controlPanel);
        mainFrame.setVisible(true);
    }

    private JButton getSubmitButton() {

        JButton submitButton = createButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });

        return submitButton;
    }

    private JComboBox<String> getDealersComboBox(){
        String [] dealers = new String[]{"SeattleAudi","HondaBellevue"};
        return createComboBox(dealers);
    }

    private JSlider getSlider() {
        // Set the slider
        JSlider slider = new JSlider();
        slider.setMinorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setFont(new Font("Arial", Font.PLAIN, 36));

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

    private JLabel pictures() throws IOException{
        JLabel picLabel = createPicture("C:\\Users\\diksh\\Desktop\\image.jpg");
        return picLabel;
    }
}
