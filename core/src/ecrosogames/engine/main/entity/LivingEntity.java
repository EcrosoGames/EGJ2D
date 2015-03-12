package ecrosogames.engine.main.entity;

import com.badlogic.gdx.physics.box2d.World;

/**
 * A {@link PhysicalEntity} that can be classified as "living."
 * 
 * @author Michael Musgrove
 */
public abstract class LivingEntity extends PhysicalEntity implements Damageable, Targetable {

	protected float health = 10f;
	protected float maxHealth = health;
	protected Targetable target;

	/**
	 * Creates a new LivingEntity and sets its {@link World}.
	 * 
	 * @param world
	 *            The {@link World}.
	 */
	public LivingEntity(World world) {
		super(world);
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
