package ecrosogames.engine.main.entity;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.World;

/**
 * A {@link AbstractPhysicalEntity} that can be classified as "living."
 * 
 * @author Michael Musgrove
 */
public abstract class AbstractLivingEntity extends AbstractPhysicalEntity implements Damageable, Targetable {

	protected float health = 10f;
	protected float maxHealth = health;
	protected Targetable target;

	/**
	 * @see {@link AbstractPhysicalEntity#PhysicalEntity(World)}.
	 */
	public AbstractLivingEntity(World world) {
		super(world);
	}

	/**
	 * @see {@link AbstractPhysicalEntity#PhysicalEntity(World, Sprite)}.
	 */
	public AbstractLivingEntity(World world, Sprite sprite) {
		super(world, sprite);
	}

	/**
	 * @see {@link AbstractPhysicalEntity#PhysicalEntity(World, Sprite, float, float)}.
	 */
	public AbstractLivingEntity(World world, Sprite sprite, float x, float y) {
		super(world, sprite, x, y);
	}

	@Override
	public void damage(float amount) {
		this.health -= amount;
		if (health < 0) health = 0;
	}

	@Override
	public void heal(float amount) {
		this.health += amount;
		if (health > maxHealth) health = maxHealth;
	}

	@Override
	public float getHealth() {
		return health;
	}

	@Override
	public void setHealth(float health) {
		this.health = health;
	}

	@Override
	public float getMaxHealth() {
		return maxHealth;
	}

	@Override
	public void setMaxHealth(float maxHealth) {
		this.maxHealth = maxHealth;
	}

	@Override
	public Targetable getTarget() {
		return target;
	}

	@Override
	public void setTarget(Targetable target) {
		this.target = target;
	}
}
