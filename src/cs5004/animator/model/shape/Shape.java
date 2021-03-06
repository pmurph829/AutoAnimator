package cs5004.animator.model.shape;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import cs5004.animator.model.transformation.Transformation;

/**
 * This interface represents a shape. A Shape has a 2D reference point for it's position, a base and
 * height, and a list of all Transformations that will be applied to it.
 */
public interface Shape {

  /**
   * Returns a copy of the shape with the same attributes.
   *
   * @return new Shape copy of the shape.
   */
  Shape copy();

  /**
   * Determine if a Shape has been initialized.
   *
   * @return true if the shape has been given initial values, false otherwise.
   */
  boolean isInitialized();

  /** Sets the initialized field to true. */
  void initialize();

  /**
   * Sets the starting frame of the shape.
   *
   * @param val the value of the starting frame.
   */
  void setStartFrame(float val);

  float getStartFrame();

  /**
   * Sets the ending frame of the shape.
   *
   * @param val the value of the ending frame.
   */
  void setEndFrame(float val);

  /**
   * Get the last frame that the shape is visible.
   *
   * @return the end frame of the shape.
   */
  float getEndFrame();

  /**
   * Returns the identifier for the shape.
   *
   * @return the identifier.
   */
  String getIdentifier();

  /**
   * Returns the position of the shape.
   *
   * @return Point2D as a reference to shape position.
   */
  Point2D getPosition();

  /**
   * Sets the position of the shape.
   *
   * @param x the x coordinate of the new position.
   * @param y the y coordinate of the new position.
   */
  void setPosition(float x, float y);

  /**
   * Resizes the shape by the given factor.
   *
   * @param newBase the new base of the Shape object.
   * @param newHeight the new height of the Shape object.
   */
  void resize(float newBase, float newHeight);

  /**
   * Get the base of the Shape.
   *
   * @return the base.
   */
  float getBase();

  /**
   * Get the height of the Shape.
   *
   * @return the height.
   */
  float getHeight();

  /** Returns colour of the shape to an rgb value. */
  Color getColor();

  /**
   * Sets colour of the shape to an rgb value.
   *
   * @param r the red value (0 - 255).
   * @param g the green value (0 - 255).
   * @param b the blue value (0 - 255).
   */
  void setColor(int r, int g, int b);

  /**
   * Returns whether the shape is visible on the canvas.
   *
   * @return true if shape appears, false otherwise.
   */
  boolean isVisible();

  /**
   * Sets the visibility attribute to true of false.
   *
   * @param val true or false depending on if the shape should be visible or not.
   */
  void setVisibility(boolean val);

  /**
   * Adds a transformation to the list of transformations for the shape.
   *
   * @param transformation the Transformation object to add.
   */
  void addTransformation(Transformation transformation);

  /**
   * Create a ChangeVisibility transformation that defines the starting and ending frames of the
   * shape.
   */
  void setFrames();

  /**
   * Returns the list of transformations for the shape.
   *
   * @return list of Transformation objects.
   */
  ArrayList<Transformation> getTransformations();

  /**
   * Returns an SVGView text output of the shapes with their animations.
   *
   * @param delay the delay (in ms) between each frame.
   * @return text as SVGView representation of the shapes with their animations
   */
  String toSVGString(float delay);

  /**
   * Draws the shape on a JPanel.
   *
   * @param g the Graphics2D object that represents this shape.
   */
  void fill(Graphics2D g);
}
