package ecrosogames.engine.main.entity;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.World;

/**
 * A type of {@link AbstractLivingEntity} that is hostile to another type of
 * {@link AbstractLivingEntity} for any reason.
 * 
 * @author Michael Musgrove
 */
public abstract class AbstractHostileEntity extends AbstractLivingEntity {

	protected boolean hostile = true;
	protected Targetable target;

	/**
	 * @see {@link AbstractPhysicalEntity#PhysicalEntity(World)}.
	 */
	public AbstractHostileEntity(World world) {
		super(world);
	}

	/**
	 * @see {@link AbstractPhysicalEntity#PhysicalEntity(World, Sprite)}.
	 */
	public AbstractHostileEntity(World world, Sprite sprite) {
		super(world, sprite);
	}

	/**
	 * @see {@link AbstractPhysicalEntity#PhysicalEntity(World, Sprite, float, float)}.
	 */
	public AbstractHostileEntity(World world, Sprite sprite, float x, float y) {
		super(world, sprite, x, y);
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
