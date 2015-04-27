package ecrosogames.engine.main;

import com.badlogic.gdx.math.Vector2;

/**
 * Something that has a position in the form <code>{ x, y }</code>. Any type of
 * {@link Number} is acceptable.
 * 
 * @author Michael Musgrove
 */
public interface Positionable2D<T extends Number> {

	/**
	 * Returns the horizontal position.
	 * 
	 * @return
	 */
	public T getX();

	/**
	 * Returns the vertical position.
	 * 
	 * @return
	 */
	public T getY();

	/**
	 * Returns the {@link Vector2} of the position.
	 * 
	 * @return
	 */
	public Vector2 getPosition();

	/**
	 * Sets the horizontal position.
	 * 
	 * @param x
	 */
	public void setX(T x);

	/**
	 * Sets the vertical position.
	 * 
	 * @param y
	 */
	public void setY(T y);

	/**
	 * Sets the position.
	 * 
	 * @param x
	 *            Horizontal position.
	 * @param y
	 *            Vertical position.
	 */
	public void setPosition(T x, T y);
}
