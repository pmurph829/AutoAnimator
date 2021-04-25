package cs5004.animator.controller;

public interface Features {
  void playPauseEvent();

  void resetEvent();

  void loopEvent();

  void showSpeedControls();

  void changeSpeed(int fps);
}