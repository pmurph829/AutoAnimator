package cs5004.animator.controller;

import javax.naming.OperationNotSupportedException;

import cs5004.animator.view.GUIView;
import cs5004.animator.view.visual.InteractiveView;

/** Controller class for the interactive view. */
public class AnimationController implements Features {
  private final GUIView view;

  /**
   * Instantiate a controller object.
   *
   * @param v the interactive view object that this controller deals with.
   * @throws OperationNotSupportedException if the view passed is not an InteractiveView.
   */
  public AnimationController(InteractiveView v) throws OperationNotSupportedException {
    this.view = v;
    this.view.addFeatures(this);
    this.view.reset();
  }

  @Override
  public void playPauseEvent() {
    try {
      view.playPause();

    } catch (OperationNotSupportedException exception) {
      exception.printStackTrace();
    }
  }

  @Override
  public void resetEvent() {
    try {
      view.reset();
    } catch (OperationNotSupportedException exception) {
      exception.printStackTrace();
    }
  }

  @Override
  public void loopEvent() {
    try {
      view.toggleLoop();
    } catch (OperationNotSupportedException exception) {
      exception.printStackTrace();
    }
  }

  @Override
  public void showSpeedControls() {
    try {
      view.showSpeedControls();
    } catch (OperationNotSupportedException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void changeSpeed(int fps) {
    try {
      view.setSpeed(fps);
    } catch (OperationNotSupportedException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void showSaveControls() {}
}
