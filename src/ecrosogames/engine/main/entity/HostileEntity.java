package ecrosogames.engine.main.entity;

import com.badlogic.gdx.physics.box2d.World;

/**
 * A type of {@link LivingEntity} that is hostile to another type of
 * {@link LivingEntity} for any reason.
 * 
 * @author Michael Musgrove
 */
public abstract class HostileEntity extends LivingEntity {

	protected boolean hostile = true;
	protected Targetable target;

	/**
	 * Creates a new HostileEntity and registers it to the specified
	 * {@link World}.
	 * 
	 * @param world
	 */
	public HostileEntity(World world) {
		super(world);
	}

	/**
	 * Sets whether or not the HostileEntity is currently in hostile mode.
	 * 
	 * @param hostile
	 *            Whether or not the HostileEntity should currently be hostile.
	 */
	public void setHostile(boolean hostile) {
		this.hostile = hostile;
	}

	/**
	 * Returns <code>true</code> if the entity is currently hostile, or
	 * <code>false</code> if it is not.
	 * 
	 * @return
	 */
	public boolean isHostile() {
		return hostile;
	}
}
