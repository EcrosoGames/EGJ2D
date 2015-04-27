package ecrosogames.engine.main.entity;

import com.badlogic.gdx.physics.box2d.World;

import ecrosogames.engine.main.Updatable;

/**
 * An Entity is an object in the game that is interactable in some form.
 * 
 * @author Michael Musgrove
 */
public abstract class AbstractEntity implements Updatable {

	protected World world;
	protected boolean removed;

	/**
	 * Creates a new Entity in the specified World
	 * 
	 * @param world
	 */
	public AbstractEntity(World world) {
		this.world = world;
	}

	@Override
	public void update() {
		if (removed) return;
	}

	/**
	 * Sets the entity's world.
	 * 
	 * @param world
	 */
	public void setWorld(World world) {
		this.world = world;
	}

	/**
	 * Returns the World for the Entity.
	 * 
	 * @return
	 */
	public World getWorld() {
		return world;
	}

	/**
	 * Sets the Entity removed to true.
	 */
	public void remove() {
		removed = true;
	}

	/**
	 * Returns if the Entity is removed or not.
	 * 
	 * @return
	 */
	public boolean isRemoved() {
		return removed;
	}
}
