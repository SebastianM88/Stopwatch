import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stopwatch implements ActionListener {

    /* Here are all elements and variables which we are going
    to use in project */
    JFrame frame = new JFrame();
    JButton startButton = new JButton("START");
    JButton resetButton = new JButton("RESET");
    JLabel timeLabel = new JLabel();
    int elapsedTime = 0;
    int seconds = 0;
    int minutes = 0;
    int hours = 0;
    boolean started = false;

    /* This is the code used to provide each unit of measurement used a
    format of two zeros as in our case. */
    String seconds_string = String.format("%02d", seconds);
    String minutes_string = String.format("%02d", minutes);
    String hours_string = String.format("%02d", hours);

    /* This is the code used to make our timer work and
    which we set to have a delay of 1000 ms */
    Timer timer = new Timer(1000, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

            // This is the code used to set the change by seconds, hours, minutes, also here we set the font
            elapsedTime = elapsedTime + 1000;
            hours = (elapsedTime/3600000);
            minutes = (elapsedTime/60000) % 60;
            seconds = (elapsedTime/1000) % 60;
            seconds_string = String.format("%02d", seconds);
            minutes_string = String.format("%02d", minutes);
            hours_string = String.format("%02d", hours);
            timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);

        }
    });

    // This is the constructor that will initialize our object.
    Stopwatch(){

        // The code for setting the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(520,420);
        frame.setLayout(null);

        
        timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
        timeLabel.setBounds(100,100,300,100);
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 35));
        timeLabel.setHorizontalAlignment(JTextField.CENTER);
        timeLabel.setOpaque(true);

        startButton.setBounds(100,200,150,50);
        startButton.setFont(new Font("Ink Free", Font.PLAIN, 20));
        startButton.setFocusable(false);
        startButton.addActionListener(this);

        resetButton.setBounds(250,200,150,50);
        resetButton.setFont(new Font("Ink Free", Font.PLAIN, 20));
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        frame.add(timeLabel);
        frame.add(startButton);
        frame.add(resetButton);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Code required to set all the features of the Start button
        if (e.getSource()==startButton) {

            if (!started) {

                started = true;
                startButton.setText("STOP");
                start();
            } else {

               started = false;
               startButton.setText("REPLAY");
               stop();
            }
        }

        // Code required to set all the features of the Stop button
        if (e.getSource()== resetButton) {

            started = false;
            startButton.setText("START");
            reset();
        }
    }

    // Connection of the timer to the Start button
    void start() {

        timer.start();
    }

    // Connection of the timer to the Start button
    void stop() {

        timer.stop();
    }

    // Connecting the timer to the Restart button and each item that it will reset
    void reset() {

        timer.stop();
        elapsedTime = 0;
        seconds = 0;
        minutes = 0;
        hours = 0;
        seconds_string = String.format("%02d", seconds);
        minutes_string = String.format("%02d", minutes);
        hours_string = String.format("%02d", hours);
        timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
    }
}
