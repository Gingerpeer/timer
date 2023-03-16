import java.awt.event.*;
import javax.swing.*;

public class StopWatchLabel extends JLabel implements MouseListener, ActionListener {

   // private long pauseTime; // Add a variable to store pause time
   private long elapsedTime; // Add a variable to store elapsed time
   private long lastStartTime; // Add a variable to store the last start time

   // private long startTime;
   private boolean running;
   private Timer timer;

   public StopWatchLabel() {
      super("  Click to start timer.  ", JLabel.CENTER);
      addMouseListener(this);
      timer = new Timer(200, this); // Create a timer with a delay of 200 milliseconds
   }

   public boolean isRunning() {
      return running;
   }
 
   public void togglePause() {
        if (running) {
            running = false;
            elapsedTime += (System.currentTimeMillis() - lastStartTime);
            timer.stop();
        } else {
            running = true;
            lastStartTime = System.currentTimeMillis();
            timer.start();
        }
    }

    public void reset() {
      running = false;
      elapsedTime = 0; // Reset the elapsed time
      lastStartTime = 0; // Reset the last start time
      setText("Click to start timer.");
      timer.stop();
  }
    public void mousePressed(MouseEvent evt) {
      if (running == false) {
          // Record the time and start the timer.
          running = true;
          lastStartTime = System.currentTimeMillis(); // Initialize lastStartTime
          timer.start();
          setText("Timing...");
      } else {
          reset();
      }
  }

   // Implement actionPerformed to handle timer events
   @Override
   public void actionPerformed(ActionEvent evt) {
      if (running) {
          long currentTime = System.currentTimeMillis();
          long totalMilliseconds = elapsedTime + currentTime - lastStartTime;
          int seconds = (int) (totalMilliseconds / 1000);
          setText("Time: " + seconds + " sec.");
      }
  }

   public void mouseReleased(MouseEvent evt) { }
   public void mouseClicked(MouseEvent evt) { }
   public void mouseEntered(MouseEvent evt) { }
   public void mouseExited(MouseEvent evt) { }

}
