package ictgradschool.industry.lab11.ex01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A simple GUI app that does BMI calculations.
 */
public class ExerciseOnePanel extends JPanel implements ActionListener {

    // TODO Declare JTextFields and JButtons as instance variables here.
    private JButton calculateBMIButton, calculateHealthyButton;
    private JTextField heightField, weightField, bmiField, healthyWeighField;

    /**
     * Creates a new ExerciseOnePanel.
     */
    public ExerciseOnePanel() {
        setBackground(Color.white);

        // TODO Construct JTextFields and JButtons.
        // HINT: Declare them as instance variables so that other methods in this class (e.g. actionPerformed) can
        // also access them.

        heightField = new JTextField(15);
        weightField = new JTextField(15);
        bmiField = new JTextField(15);
        healthyWeighField = new JTextField(15);

        calculateBMIButton = new JButton("Calculate BMI");
        calculateHealthyButton = new JButton("Calculate Healthy Weight");

        // TODO Declare and construct JLabels
        // Note: These ones don't need to be accessed anywhere else so it makes sense just to declare them here as
        // local variables, rather than instance variables.

        JLabel heightLabel = new JLabel("Height in metres:");
        JLabel weightLabel = new JLabel("Weight in kilograms:");
        JLabel bmiLabel = new JLabel("Your body mass index (bmi) is:");
        JLabel healthyWeightLabel = new JLabel("Maximum healthy weight for your height:");

        // TODO Add JLabels, JTextFields and JButtons to window.
        // Note: The default layout manager, FlowLayout, will be fine (but feel free to experiment with others if you want!!)
        add(heightLabel);
        add(heightField);
        add(weightLabel);
        add(weightField);
        add(calculateBMIButton);
        add(bmiLabel);
        add(bmiField);
        add(calculateHealthyButton);
        add(healthyWeightLabel);
        add(healthyWeighField);

        // TODO Add Action Listeners for the JButtons
        calculateBMIButton.addActionListener(this);
        calculateHealthyButton.addActionListener(this);
    }


    /**
     * When a button is clicked, this method should detect which button was clicked, and display either the BMI or the
     * maximum healthy weight, depending on which JButton was pressed.
     */
    public void actionPerformed(ActionEvent event) {

        double height, weight, bmi, maxHealthyWeight;

        // TODO Implement this method.
        // Hint #1: event.getSource() will return the button which was pressed.
        // Hint #2: JTextField's getText() method will get the value in the text box, as a String.
        // Hint #3: JTextField's setText() method will allow you to pass it a String, which will be diaplayed in the text box.

        height = Double.parseDouble(heightField.getText());
        weight = Double.parseDouble(weightField.getText());
        bmi = weight / (height * height);
        maxHealthyWeight = 24.9 * height * height;

        if (event.getSource() == calculateBMIButton) {
            bmiField.setText("" + roundTo2DecimalPlaces(bmi));
        }

        if (event.getSource() == calculateHealthyButton) {
            healthyWeighField.setText("" + roundTo2DecimalPlaces(maxHealthyWeight));
        }
    }

    /**
     * A library method that rounds a double to 2dp
     *
     * @param amount to round as a double
     * @return the amount rounded to 2dp
     */
    private double roundTo2DecimalPlaces(double amount) {
        return ((double) Math.round(amount * 100)) / 100;
    }

}