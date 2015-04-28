package ecrosogames.engine.main.entity;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.World;

import ecrosogames.engine.main.Positionable2D;
import ecrosogames.engine.main.Renderable;

/**
 * A PhysicalEntity is an {@link AbstractEntity} that has a physical form.
 * 
 * @author Michael Musgrove
 */
public abstract class AbstractPhysicalEntity extends AbstractEntity implements Renderable, Positionable2D<Float> {

	protected Body body;
	protected Sprite sprite;
	protected Vector2 movementLeft;
	protected Vector2 movementRight;
	protected Vector2 jumpForce;

	/**
	 * Creates a new PhysicalEntity.
	 * 
	 * @param world
	 *            The {@link World} that the PhysicalEntity should be registered
	 *            to.
	 */
	public AbstractPhysicalEntity(World world) {
		super(world);
		createBody();
		initializeMovementVariables();
	}

	/**
	 * Creates a new PhysicalEntity with a {@link Sprite}.
	 * 
	 * @param world
	 *            The {@link World} that the PhysicalEntity should be registered
	 *            to.
	 * @param sprite
	 *            The {@link Sprite} that the PhysicalEntity should be rendered
	 *            with. The {@link Body} should have appropriate
	 *            <code>{@link Fixture}s</code> for collision.
	 */
	public AbstractPhysicalEntity(World world, Sprite sprite) {
		this(world);
		this.sprite = sprite;
	}

	/**
	 * Creates a new PhysicalEntity with a {@link Sprite} and position.
	 * 
	 * @param world
	 *            The {@link World} that the PhysicalEntity should be registered
	 *            to.
	 * @param sprite
	 *            The {@link Sprite} that the PhysicalEntity should be rendered
	 *            with. The {@link Body} should have appropriate
	 *            <code>{@link Fixture}s</code> for collision.
	 * @param x
	 *            The horizontal position.
	 * @param y
	 *            The vertical position.
	 */
	public AbstractPhysicalEntity(World world, Sprite sprite, float x, float y) {
		this(world, sprite);
		setPosition(x, y);
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

	protected void initializeMovementVariables() {
		movementLeft = new Vector2(-5f * body.getMass(), 0f);
		movementRight = new Vector2(5f * body.getMass(), 0f);
		jumpForce = new Vector2(0f, Math.abs(world.getGravity().y) * body.getMass());
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

	@Override
	public Float getX() {
		return body.getTransform().getPosition().x;
	}

	@Override
	public Float getY() {
		return body.getTransform().getPosition().y;
	}

	@Override
	public Vector2 getPosition() {
		return body.getTransform().getPosition();
	}

	@Override
	public void setX(Float x) {
		body.setTransform(x, getY(), body.getAngle());
	}

	@Override
	public void setY(Float y) {
		body.setTransform(getX(), y, body.getAngle());
	}

	@Override
	public void setPosition(Float x, Float y) {
		body.setTransform(x, y, body.getAngle());
	}
}
