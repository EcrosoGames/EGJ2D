package ecrosogames.engine.main.entity;

/**
 * An interface used to be a host for all methods for any {@link AbstractEntity} that is
 * or has the ability to be hostile.
 * 
 * @author Michael Musgrove
 */
public interface Hostile {

	/**
	 * Sets whether or not the Hostile is currently in hostile mode.
	 * 
	 * @param hostile
	 *            Whether or not the Hostile should currently be hostile.
	 */
	public void setHostile(boolean hostile);

	/**
	 * Returns <code>true</code> if the Hostile is currently hostile, or
	 * <code>false</code> if it is not.
	 * 
	 * @return
	 */
	public boolean isHostile();
}
