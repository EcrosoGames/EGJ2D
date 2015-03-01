package ecrosogames.engine.main.entity;

/**
 * An interface that allows something to be a target.
 * 
 * @author Michael Musgrove
 */
public interface Targetable {

	/**
	 * The current target.
	 * 
	 * @return
	 */
	public Targetable getTarget();

	/**
	 * Sets the target for the implementing class.
	 * 
	 * @param target
	 *            The new target.
	 */
	public void setTarget(Targetable target);
}
