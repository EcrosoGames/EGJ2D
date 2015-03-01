package ecrosogames.engine.main.entity;

/**
 * An entity that can be damaged.
 * 
 * @author Michael Musgrove
 */
public interface Damageable {

	/**
	 * The amount of damage to take away from the entity. This should be a
	 * positive number.
	 * 
	 * @param amount
	 *            The amount of health to take away from the entity.
	 */
	public void damage(float amount);

	/**
	 * The amount of health to give to the entity. This should be a positive
	 * number.
	 * 
	 * @param amount
	 *            The amount of health to give to the entity.
	 */
	public void heal(float amount);

	/**
	 * Returns the current health of the entity.
	 * 
	 * @return
	 */
	public float getHealth();

	/**
	 * Sets the entity's health.
	 * 
	 * @param health
	 *            The new health of the entity.
	 */
	public void setHealth(float health);

	/**
	 * Returns the maximum health of the entity.
	 * 
	 * @return
	 */
	public float getMaxHealth();

	/**
	 * Sets the maximum health of the entity.
	 * 
	 * @param maxHealth
	 */
	public void setMaxHealth(float maxHealth);
}
