package model.transformation;

import model.shape.Shape;

/**
 * Transformation interface that defines behavior shared by all transformation objects.
 * A transformation has one Shape and must be able to determine the state of that Shape
 * at any given (viable) frame number.
 */
public interface Transformation {

  /**
   * Determine the state (position, visibility, size, or color) of the Shape object at the current
   * frame.
   *
   * @param frame the frame to be rendered.
   * @return A COPY of the original shape object that reflects results of the transformation at the
   * given frame.
   * @throws IllegalArgumentException if the given frame is negative
   */
  Shape executeAtFrame(int frame) throws IllegalArgumentException;

  /**
   * Return the starting frame of the transformation.
   *
   * @return the start frame.
   */
  int getStartFrame();

  /**
   * Determine the the value of some parameter at a given frame.
   *
   * @param frame        the frame to calculate the value at.
   * @param initialValue The starting value of the parameter.
   * @param finalValue   the ending value of the parameter.
   * @return the value the parameter will have at the given frame.
   * @throws IllegalArgumentException if the frame is negative.
   */
  float getValueAtFrame(int frame, float initialValue, float finalValue) throws IllegalArgumentException;

}
