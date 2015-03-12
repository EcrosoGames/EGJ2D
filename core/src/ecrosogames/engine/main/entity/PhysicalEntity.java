package ecrosogames.engine.main.entity;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

/**
 * A PhysicalEntity is an {@link Entity} that has a physical form.
 * 
 * @author Michael Musgrove
 */
public abstract class PhysicalEntity extends Entity {

	protected Body body;
	protected Sprite sprite;

	/**
	 * Creates a new PhysicalEntity.
	 * 
	 * @param world
	 *            The {@link World} that the PhysicalEntity should be registered
	 *            to.
	 */
	public PhysicalEntity(World world) {
		super(world);
		createBody();
	}

	/**
	 * A method that is designed for creating the PhysicalEntity's body.
	 */
	protected abstract void createBody();

	/**
	 * A disposal method for the entity when it is no longer needed.
	 */
	public void dispose() {
		if (body != null) body.getWorld().destroyBody(body);
	}

	/**
	 * Sets the {@link Body} of the PhysicalEntity.
	 * 
	 * @param body
	 */
	public void setBody(Body body) {
		this.body = body;
	}

	/**
	 * Sets the {@link Sprite} of the PhysicalEntity.
	 * 
	 * @param sprite
	 */
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	/**
	 * Returns the {@link Body} for this PhysicalEntity.
	 * 
	 * @return
	 */
	public Body getBody() {
		return body;
	}

	/**
	 * Returns the {@link Sprite} for this PhysicalEntity.
	 * 
	 * @return
	 */
	public Sprite getSprite() {
		return sprite;
	}
}
