package ictgradschool.industry.lab11.ex02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A simple JPanel that allows users to add or subtract numbers.
 *
 * TODO Complete this class. No hints this time :)
 */
public class ExerciseTwoPanel extends JPanel implements ActionListener {

    private JTextField num1Field, num2Field, resultField;
    private JButton addButton, subtractButton;

    /**
     * Creates a new ExerciseFivePanel.
     */
    public ExerciseTwoPanel() {
        setBackground(Color.white);

        num1Field = new JTextField(15);
        num2Field = new JTextField(15);
        addButton = new JButton("Add");
        subtractButton = new JButton("Subtract");
        JLabel resultLabel = new JLabel("Result:");
        resultField = new JTextField(20);

        add(num1Field);
        add(num2Field);
        add(addButton);
        add(subtractButton);
        add(resultLabel);
        add(resultField);

        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {

        double num1, num2, addSum, subtractSum;

        num1 = Double.parseDouble(num1Field.getText());
        num2 = Double.parseDouble(num2Field.getText());
        addSum = num1 + num2;
        subtractSum = num1 - num2;

        if (event.getSource() == addButton) {
            resultField.setText("" + roundTo2DecimalPlaces(addSum));
        }

        if (event.getSource() == subtractButton) {
            resultField.setText("" + roundTo2DecimalPlaces(subtractSum));
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