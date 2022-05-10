package ictgradschool.industry.lab11.ex04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Displays an animated balloon.
 */
public class ExerciseFourPanel extends JPanel implements ActionListener, KeyListener {

    private  Balloon balloon;
//    private  JButton moveButton;
    private Timer timer;

    /**
     * Creates a new ExerciseFourPanel.
     */
    public ExerciseFourPanel() {
        setBackground(Color.white);

        this.balloon = new Balloon(30, 60);

        addKeyListener(this);

        timer = new Timer(10, this);

//        this.moveButton = new JButton("Move balloon");
//        this.moveButton.addActionListener(this);
//        this.add(moveButton);

    }



    @Override
    public void keyPressed(KeyEvent e) {
        if (!timer.isRunning()) {
            timer.start();
        }

        switch(e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                balloon.setDirection(Direction.Left);
                break;
            case KeyEvent.VK_RIGHT:
                balloon.setDirection(Direction.Right);
                break;
            case KeyEvent.VK_UP:
                balloon.setDirection(Direction.Up);
                break;
            case KeyEvent.VK_DOWN:
                balloon.setDirection(Direction.Down);
                break;
            case KeyEvent.VK_S:
                timer.stop();
        }
    }



    /**
     * Moves the balloon and calls repaint() to tell Swing we need to redraw ourselves.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        balloon.move();


        // Sets focus to the panel itself, rather than the JButton. This way, the panel can continue to generate key
        // events even after we've clicked the button.
        requestFocusInWindow();

        repaint();
    }

    /**
     * Draws any balloons we have inside this panel.
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        balloon.draw(g);
        
        // Sets focus outside of actionPerformed so key presses work without pressing the button
        requestFocusInWindow();
    }


    // unused implemented methods
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}