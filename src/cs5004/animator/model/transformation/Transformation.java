package cs5004.animator.model.transformation;

import cs5004.animator.model.shape.Shape;

/**
 * Transformation interface that defines behavior shared by all transformation objects. A
 * transformation has one Shape and must be able to determine the state of that Shape at any given
 * (viable) frame number.
 */
public interface Transformation<T> {

  /**
   * Get the type of Transformation.
   *
   * @return the type of the Transformation object.
   */
  TransformationType getType();

  /**
   * Used in resize to tell if the base or the height will be changed.
   *
   * @return base or height.
   */
  dimension getDimension();

  /**
   * Checks if two transformations are conflicting with each other.
   *
   * @param t the new transformation to compare with
   * @return true if transformations are conflicting, false otherwise
   */
  boolean hasConflictingTransformation(Transformation t);

  /**
   * Determine the state (position, visibility, size, or color) of the Shape object at the current
   * frame.
   *
   * @param s the shape object in question.
   * @param frame the frame to be rendered.
   * @return the result of the transformation at a given frame. Will be used to set the Shape state
   *     at the given frame. Note: the return type is different for each subclass and must be cast
   *     to the appropriate data type to work properly.
   * @throws IllegalArgumentException if the given frame is negative.
   */
  T executeAtFrame(Shape s, float frame) throws IllegalArgumentException;

  /**
   * Return the starting frame of the transformation.
   *
   * @return the start frame.
   */
  float getStartFrame();

  /**
   * Return the ending frame of the transformation.
   *
   * @return the end frame.
   */
  float getEndFrame();

  /**
   * Determine the the value of some parameter at a given frame.
   *
   * @param frame the frame to calculate the value at.
   * @param currentValue The current value of the parameter, in case the frame is outside the scope
   *     of the transformation.
   * @param initialValue The starting value of the parameter.
   * @param finalValue the ending value of the parameter.
   * @return the value the parameter will have at the given frame.
   * @throws IllegalArgumentException if the frame is negative.
   */
  float getValueAtFrame(float frame, float currentValue, float initialValue, float finalValue)
      throws IllegalArgumentException;

  /**
   * Returns an SVGView text output of the transformations/animations.
   *
   * @param type The type of shape.
   * @param delay the delay (in ms) between each frame.
   * @return text as SVGView representation of the transformation.
   */
  String toSVGString(String type, float delay);
}
