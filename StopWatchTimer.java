import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StopWatchTimer {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Stopwatch Timer");
        StopWatchLabel stopWatchLabel = new StopWatchLabel();

        JButton pauseButton = new JButton("Pause");
        JButton resetButton = new JButton("Reset");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(pauseButton);
        buttonPanel.add(resetButton);

        frame.setLayout(new BorderLayout());
        frame.add(stopWatchLabel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);

        frame.getContentPane().setBackground(Color.BLACK);
        stopWatchLabel.setBackground(Color.BLACK);
        stopWatchLabel.setOpaque(true);
        stopWatchLabel.setForeground(Color.WHITE);

        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopWatchLabel.togglePause();
                if (stopWatchLabel.isRunning()) {
                    pauseButton.setText("Pause");
                } else {
                    pauseButton.setText("Continue");
                }
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopWatchLabel.reset();
                pauseButton.setText("Pause"); // Reset the pause button's text
            }
        });

        frame.setVisible(true);
    }
}
