package ecrosogames.engine.interfaces;

/**
 * This is for any class that supports an update() method.
 * 
 * @author Michael Musgrove (CoderMusgrove)
 */
public interface Updatable {

	/**
	 * Anything that should require a periodic update. No rendering should be
	 * done inside of this method.
	 */
	public abstract void update();
}
