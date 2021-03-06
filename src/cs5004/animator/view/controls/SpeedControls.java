package cs5004.animator.view.controls;

import java.awt.Dimension;
import java.awt.BorderLayout;

import javax.naming.OperationNotSupportedException;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import cs5004.animator.controller.Features;

/** GUI that can increase or decrease the speed of the animation. */
public class SpeedControls extends JFrame implements Controls {
  private int fps;
  private final JButton increaseSpeed = new JButton("+");
  private final JButton decreaseSpeed = new JButton("-");
  private final JTextField currentFPS;

  /**
   * Create an instance of SpeedControls.
   *
   * @param fps the initial speed of the animation.
   */
  public SpeedControls(int fps) {
    this.fps = fps;
    currentFPS = new JTextField(String.valueOf(this.fps), 3);
    currentFPS.setHorizontalAlignment(JTextField.CENTER);
    currentFPS.setEditable(false);
    JTextArea fpsLabel = new JTextArea("Current FPS:");
    fpsLabel.setEditable(false);
    setPreferredSize(new Dimension(200, 100));
    setLayout(new BorderLayout());
    add(decreaseSpeed, BorderLayout.WEST);
    add(increaseSpeed, BorderLayout.EAST);
    add(fpsLabel, BorderLayout.NORTH);
    add(currentFPS, BorderLayout.CENTER);
    pack();
    setTitle("Change Speed");
    setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    setVisible(false);
  }

  @Override
  public void setFps(int newFPS) {
    this.fps = newFPS;
    this.currentFPS.setText(String.valueOf(newFPS));
  }

  @Override
  public void showSpeedControls() {
    setVisible(true);
  }

  @Override
  public void addFeatures(Features features) {
    decreaseSpeed.addActionListener(l -> features.changeSpeed(this.fps - 1));
    increaseSpeed.addActionListener(l -> features.changeSpeed(this.fps + 1));
  }

  @Override
  public String getFilename() throws OperationNotSupportedException {
    throw new OperationNotSupportedException("Operation not supported");
  }

  @Override
  public void updatePlayPauseTitle(String title) throws OperationNotSupportedException {
    throw new OperationNotSupportedException("Operation not supported");
  }

  //  @Override
  //  public void setFilename() throws OperationNotSupportedException {
  //    throw new OperationNotSupportedException("Operation not supported");
  //  }
}
