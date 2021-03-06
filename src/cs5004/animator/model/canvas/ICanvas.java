package cs5004.animator.model.canvas;

import java.util.ArrayList;

import cs5004.animator.model.shape.Shape;
import cs5004.animator.model.transformation.Transformation;

/**
 * * transformations that will be applied throughout the animation. Can return the state of all
 * shape Represents the canvass for the animation. Contains the initial shape objects and all *
 * objects at a given frame.
 */
public interface ICanvas {

  /**
   * Get all initial shapes in a canvas object.
   *
   * @return list of initial shapes.
   */
  ArrayList<Shape> getInitialShapes();

  /**
   * Add a visibility transformation to each shape in the canvas that has it's start and end frame.
   */
  void setAllFrames();

  /**
   * Set the starting position and the border size of the ICanvas.
   *
   * @param leftMostX the minimum x value (top left corner).
   * @param topMostY the minimum y value (top left corner).
   * @param borderWidth the width of the ICanvas.
   * @param borderHeight the height of the ICanvas.
   */
  void setCanvasBounds(int leftMostX, int topMostY, int borderWidth, int borderHeight);

  /**
   * Returns a text description of the shapes and their transformations.
   *
   * @return string representation of each shape and the transformations.
   */
  String toString();

  /**
   * Returns an SVGView text output of the canvas with its shapes and their animations.
   *
   * @param delay the delay (in ms) between each frame.
   * @return text as SVGView representation of the canvas with its shapes and their animations
   */
  String toSVGString(float delay);

  /** Resets the mutated shapes in the canvas to their original states. */
  void resetDynamicShapes();

  /**
   * Get the state of all shapes at a given frame.
   *
   * @param frame the frame that will eventually be rendered in the cs5004.animator.view.
   * @return A list of all shape objects to be rendered in the frame.
   */
  ArrayList<Shape> getShapesAtFrame(float frame);

  /**
   * Get a shape object by passing its identifier.
   *
   * @param id the shape id.
   * @return the Shape object with that id.
   */
  Shape getShapeById(String id);

  /**
   * Adds a Shape object with its identifier as a key to the map of initial shapes.
   *
   * @param shape the Shape object.
   */
  void addShape(Shape shape);

  /**
   * Remove a Shape by id.
   *
   * @param id the identifier of the Shape to be removed.
   */
  void removeShape(String id);

  /**
   * Adds a Transformation object to the list of transformations, then sorts the list so all
   * transformations are order of starting frame.
   *
   * @param shapeID the identifier of the shape.
   * @param transformation the Transformation object.
   * @throws IllegalArgumentException if shape with given identifier is not found.
   */
  void addTransformation(String shapeID, Transformation transformation)
      throws IllegalArgumentException;

  /**
   * Returns the left-most x value.
   *
   * @return x value.
   */
  int getLeftMostX();

  /**
   * Returns the top-most y value.
   *
   * @return y value.
   */
  int getTopMostY();

  /**
   * Returns the border width of the canvas.
   *
   * @return border width.
   */
  int getBorderWidth();

  /**
   * Returns the border height of the canvas.
   *
   * @return border height.
   */
  int getBorderHeight();
}
