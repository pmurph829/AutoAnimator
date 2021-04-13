package cs5004.animator.model.canvas;

import cs5004.animator.model.shape.Shape;
import cs5004.animator.model.transformation.Transformation;
import java.util.ArrayList;

/**
 * * transformations that will be applied throughout the animation. Can return the state of all
 * shape Represents the canvass for the animation. Contains the initial shape objects and all *
 * objects at a given frame.
 */
public interface ICanvas {

  /**
   * Returns a text description of the shapes and their transformations.
   *
   * @return string representation of each shape and the transformations.
   */
  String toString();

  /**
   * Get the state of all shapes at a given frame.
   *
   * @param frame the frame that will eventually be rendered in the cs5004.animator.view.
   * @return A list of all shape objects to be rendered in the frame.
   */
  ArrayList<Shape> getShapesAtFrame(float frame);

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
}